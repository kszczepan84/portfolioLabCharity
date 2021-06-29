package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Entity.Role;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String addUserPost(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginUser() {
        return "/user/login";
    }

    @RequestMapping("/successLogin")
    public String successLogin() {
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String userEdit(Authentication authentication, Model model){
        User currentUser= userRepository.findByEmail(authentication.getName());
        model.addAttribute("user", currentUser);
        return "/user/profile";
    }

    @PostMapping("/profile")
    public String userEditSave(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/donations")
    public String userDonate(Authentication authentication, Model model){
        User user= userRepository.findByEmail(authentication.getName());
        List<Donation> allDonations = donationRepository.findAllByUser(user);
        model.addAttribute("donations",allDonations);
        return "/user/donations";
    }
    @GetMapping("/donation/delete/{id}")
    public String deleteDonation(@PathVariable Long id){
        donationRepository.deleteById(id);
        return "redirect:/user/donations";
    }

    @GetMapping("/donation/edit/{id}")
    public String editDonation(@PathVariable Long id,Model model){
       model.addAttribute("donation",donationRepository.findById(id));
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("institution",institutionRepository.findAll());
        return "/user/donation_edit";
    }

    @PostMapping("/donation/edit")
    public String editDonationPost(Donation donation){
        donationRepository.save(donation);
        return "redirect:/user/donations";

    }


    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "welcome page";
    }





}
