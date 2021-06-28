package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.Entity.Role;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.RoleRepository;
import pl.coderslab.charity.Repository.UserRepository;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

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

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "welcome page";
    }

    @RequestMapping("/donations")
    @ResponseBody
    public String userDonate(){
        return "działa podglad dotacji";
    }



}
