package pl.coderslab.charity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.UserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
//    private AccountStatusUserDetailsChecker accountStatusUserDetailsChecker;


    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
//        if ( user.getEnabled()!=1){
//            try {
//                throw new AccountLockedException("Account locked");
//            } catch (AccountLockedException e) {
//                e.printStackTrace();
//            }
//        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
        return new SpringDataUserDetails(user,grantedAuthorities);
    }
}
