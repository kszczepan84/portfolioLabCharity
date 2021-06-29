package pl.coderslab.charity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.coderslab.charity.Entity.User;

import java.util.Collection;
import java.util.Set;

public class SpringDataUserDetails implements UserDetails {

    private final User user;
    private final Set<GrantedAuthority> grantedAuthoritySet;
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public SpringDataUserDetails(User user, Set<GrantedAuthority> grantedAuthoritySet) {
        this.grantedAuthoritySet=grantedAuthoritySet;
        this.user=user;
        this.firstname=this.user.getFirstName();

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthoritySet;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
