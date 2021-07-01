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
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Entity.Role;
import pl.coderslab.charity.Entity.Status;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
    private final DonationStatusRepository donationStatusRepository;

    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String addUserPost(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
        return "redirect:/";
    }


    @GetMapping("/profile")
    public String userEdit(Authentication authentication, Model model) {
        User currentUser = userRepository.findByEmail(authentication.getName());
        model.addAttribute("user", currentUser);
        return "/user/profile";
    }

    @PostMapping("/profile")
    public String userEditSave(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/donations")
    public String userDonate(Authentication authentication, Model model) {
        User user = userRepository.findByEmail(authentication.getName());
        List<Donation> allDonations = donationRepository.findAllByUser(user);
        model.addAttribute("donations", allDonations);
        return "/user/donations";
    }

    @GetMapping("/donation/delete/{id}")
    public String deleteDonation(@PathVariable Long id) {
        donationRepository.deleteById(id);
        return "redirect:/user/donations";
    }

    @GetMapping("/donation/edit/{id}")
    public String editDonation(@PathVariable Long id, Model model) {
        Donation donation = donationRepository.findById(id).orElse(null);
        model.addAttribute("donation", donation);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institution", institutionRepository.findAll());
        for(Status status:donation.getStatus()){
            model.addAttribute("status",status);
        }
        return "/user/donation_edit";
    }

    @PostMapping("/donation/edit")
    public String editDonationPost(Donation donation) {
        donation.setStatus(donation.getStatus());
        donationRepository.save(donation);
        return "redirect:/user/donations";

    }

    @GetMapping("/donation/status/{id}")
    public String checkStatus(@PathVariable Long id, Model model) {
        Donation donation = donationRepository.findById(id).orElse(null);
        List<Status> statusList = donation.getStatus();
        for (Status status : statusList) {
            if (status.getPlaced() != null) {
                model.addAttribute("placed", status.getPlaced());
                model.addAttribute("placedDate", status.getPlacedDate());
            }
            if (status.getReceived() != null) {
                model.addAttribute("received", status.getReceived());
                model.addAttribute("receivedDate", status.getReceivedDate());
            }
            if (status.getTransferred() != null) {
                model.addAttribute("transferred", status.getTransferred());
                model.addAttribute("transferredDate", status.getTransferredDate());
            }
        }
        model.addAttribute("donation", donation);
        return "/user/status";
    }

    @GetMapping("/donation/status/received/{id}")
    public String changeStatusToReceived(@PathVariable Long id, Model model) {
        Donation donation = donationRepository.findById(id).orElse(null);
        List<Status> statusList = donation.getStatus();
        for (Status status : statusList) {
            if (status.getPlaced() != null) {
                model.addAttribute("placed", status.getPlaced());
                model.addAttribute("placedDate", status.getPlacedDate());
            }
            status.setReceived("Odebrane przez kuriera");
            status.setReceivedDate(LocalDate.now());
            donationStatusRepository.save(status);
            model.addAttribute("received", status.getReceived());
            model.addAttribute("receivedDate", status.getReceivedDate());
            if (status.getTransferred() != null) {
                model.addAttribute("transferred", status.getTransferred());
                model.addAttribute("transferredDate", status.getTransferredDate());
            }
        }

        model.addAttribute("donation", donation);
        return "/user/status";
    }

    @GetMapping("/donation/status/transferred/{id}")
    public String changeStatusToTransferred(@PathVariable Long id, Model model) {
        Donation donation = donationRepository.findById(id).orElse(null);
        List<Status> statusList = donation.getStatus();
        for (Status status : statusList) {
            if (status.getPlaced() != null) {
                model.addAttribute("placed", status.getPlaced());
                model.addAttribute("placedDate", status.getPlacedDate());
            }
            if (status.getReceived() != null) {
                model.addAttribute("received", status.getReceived());
                model.addAttribute("receivedDate", status.getReceivedDate());
            }
            status.setTransferred("Odebrane przez instytucję");
            status.setTransferredDate(LocalDate.now());
            donationStatusRepository.save(status);
            model.addAttribute("transferred", status.getTransferred());
            model.addAttribute("transferredDate", status.getTransferredDate());

        }
        model.addAttribute("donation", donation);
        return "/user/status";
    }
}
