package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Entity.Role;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.DonationRepository;
import pl.coderslab.charity.Repository.InstitutionRepository;
import pl.coderslab.charity.Repository.UserRepository;

import java.util.Collection;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutionList", institutionRepository.findAll());
        List<Donation> donations = donationRepository.findAll();
        Integer bagQuantity=0;
        Integer donationsQuantity=0;
        for ( Donation donation:donations){
            if(donation.getQuantity()!=null){
                bagQuantity  += donation.getQuantity();
            }
            donationsQuantity += 1;        }
        model.addAttribute("bagQuantity", bagQuantity);
        model.addAttribute("donationsQuantity", donationsQuantity);
        return "homepage/index";
    }

    @GetMapping("/login")
    public String loginUser() {
        return "/homepage/login";
    }

    @RequestMapping("/successLogin")
    public String successLogin(Authentication authentication) {
        User currentUser= userRepository.findByEmail(authentication.getName());
        Collection<Role> roles=currentUser.getRoles();
        for(Role role:roles){
            if(role.getName().equals("ROLE_ADMIN")){
                return "redirect:/admin/index";
            }
        }
        return "redirect:/";
    }



}


