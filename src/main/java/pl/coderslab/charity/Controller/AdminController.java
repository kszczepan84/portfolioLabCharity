package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.Institution;
import pl.coderslab.charity.Entity.Role;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.InstitutionRepository;
import pl.coderslab.charity.Repository.RoleRepository;
import pl.coderslab.charity.Repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionRepository institutionRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @RequestMapping("/institution")
    public String manageInstitutions(Model model) {
        model.addAttribute("institutions", institutionRepository.findAll());
        return "/admin/institution";
    }

    @RequestMapping("/main")
    public String index(Authentication authentication, Model model) {
        User currentUser = userRepository.findByEmail(authentication.getName());
        model.addAttribute("user", currentUser);
        return "/admin/main";
    }

    @GetMapping("/institution/add")
    public String addInstitution(Model model) {
        model.addAttribute("institution", new Institution());
        return "admin/institution_add";
    }

    @PostMapping("/institution/add")
    public String addInstitutionPost(Institution institution) {
        institutionRepository.save(institution);
        return "redirect:/admin/institution";
    }

    @GetMapping("/institution/edit/{id}")
    public String editInstitution(@PathVariable Long id, Model model) {
        model.addAttribute("institution", institutionRepository.findById(id));
        return "/admin/institution_edit";
    }

    @PostMapping("/institution/edit")
    public String editInstitutionPost(Institution institution) {
        institutionRepository.save(institution);
        return "redirect:/admin/institution";
    }

    @GetMapping("/institution/delete/{id}")
    public String deleteInstitution(@PathVariable Long id) {
        institutionRepository.deleteById(id);
        return "redirect:/admin/institution";
    }

    @RequestMapping("/admins")
    public String showAllAdmins(Model model) {
        List<Long> usersId = userRepository.selectUserByRoleAdmin();
        List<User> users = userRepository.findAllById(usersId);
        model.addAttribute("admins", users);
        return "/admin/admins";
    }

    @GetMapping("/admins/add")
    public String addAdmin(Model model) {
        model.addAttribute("user", new User());
        return "/admin/admin_add";
    }

    @PostMapping("/admins/add")
    public String addAdminPost(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
        return "redirect:/admin/admins";
    }

    @GetMapping("/admins/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "/admin/admin_edit";
    }

    @PostMapping("/admins/edit")
    public String editAdminPost(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
        return "redirect:/admin/admins";
    }

    @GetMapping("/admins/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/admins";
    }

    @RequestMapping("/users")
    public String showAllUsers(Model model) {
        List<Long> usersId = userRepository.selectUserByRoleUser();
        List<User> allUsers = userRepository.findAllById(usersId);
        model.addAttribute("users", allUsers);
        return "/admin/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "/admin/user_edit";
    }

    @PostMapping("/users/edit")
    public String editUserPost(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/enable/{id}")
    public String enableUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        user.setEnabled(1);
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/disable/{id}")
    public String disableUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        user.setEnabled(0);
        userRepository.save(user);
        return "redirect:/admin/users";
    }


}
