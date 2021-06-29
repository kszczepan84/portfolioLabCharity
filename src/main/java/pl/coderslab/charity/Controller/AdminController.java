package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.InstitutionRepository;
import pl.coderslab.charity.Repository.UserRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionRepository institutionRepository;
    private final UserRepository userRepository;

    @RequestMapping("/institution")
    public String manageInstitutions(Model model){
        model.addAttribute("institutions",institutionRepository.findAll());
        return "/admin/institution";
    }

    @RequestMapping("/main")
    public String index(Authentication authentication, Model model){
        User currentUser= userRepository.findByEmail(authentication.getName());
        model.addAttribute("user", currentUser);
        return "/admin/main";
    }

}
