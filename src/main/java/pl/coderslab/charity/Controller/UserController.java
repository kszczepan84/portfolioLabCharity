package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.UserRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String addUserPost(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

}
