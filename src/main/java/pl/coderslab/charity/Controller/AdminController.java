package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.Admin;
import pl.coderslab.charity.Entity.Role;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.AdminRepository;
import pl.coderslab.charity.Repository.RoleRepository;
import pl.coderslab.charity.Repository.UserRepository;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @GetMapping("/register")
    public String addAdmin(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/register";
    }

    @PostMapping("/register")
    public String addAdminPost(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        admin.setRoles(Arrays.asList(adminRole));
        adminRepository.save(admin);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginAdmin() {
        return "/admin/login";
    }

    @RequestMapping("/successLogin")
    public String successLogin() {
        return "redirect:/admin/index";
    }

}
