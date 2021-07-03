package pl.coderslab.charity.Controller;

import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex instanceof BadCredentialsException) {
                errorMessage = "Nazwa użytkownika/Hasło jest niepoprawne";
            }
            if (ex instanceof AccountStatusException) {
                if (ex instanceof LockedException) {
                    errorMessage = "Konto zostało zablokowane";
                }
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "homepage/login";
    }
}
