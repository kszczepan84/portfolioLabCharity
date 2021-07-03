//package pl.coderslab.charity;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.context.MessageSource;
//import org.springframework.context.MessageSourceAware;
//import org.springframework.context.support.MessageSourceAccessor;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.core.SpringSecurityMessageSource;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsChecker;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AccountStatusUserDetailsChecker implements UserDetailsChecker, MessageSourceAware {
//
//    private final Log logger = LogFactory.getLog(getClass());
//
//    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
//
//
//    @Override
//    public void setMessageSource(MessageSource messageSource) {
//
//    }
//
//    @Override
//    public void check(UserDetails userDetails) {
//        if (!userDetails.isAccountNonLocked()) {
//            this.logger.debug("Failed to authenticate since user account is locked");
//            throw new LockedException(
//                    this.messages.getMessage("AccountStatusUserDetailsChecker.locked", "User account is locked"));
//        }
//    }
//}
