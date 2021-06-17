package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
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

    @GetMapping("/register")
    public String addUser(Model model ) {
        model.addAttribute("user",new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String addUserPost(User user){
        userRepository.save(user);
        return "redirect:/";
    }
}
