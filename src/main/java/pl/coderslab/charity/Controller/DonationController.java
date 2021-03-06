package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.*;
import pl.coderslab.charity.Entity.Status;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;
    private final DonationStatusRepository donationStatusRepository;

    @GetMapping("/add")
    public String addDonation(Model model, Authentication authentication) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institution", institutionRepository.findAll());
        model.addAttribute("donation", new Donation());
        Status status = new Status();
        status.setPlaced("Zlecenie złożone");
        LocalDate localDate = LocalDate.now();
        status.setPlacedDate(localDate);
        donationStatusRepository.save(status);
        model.addAttribute("status", status);
        if (authentication != null) {
            User user = userRepository.findByEmail(authentication.getName());
            model.addAttribute("user", user);
        }
        return "donation/form";
    }

    @PostMapping("/add")
    public String addDonationPost(@Valid Donation donation, BindingResult result) {
        donationRepository.save(donation);
        return "donation/form-confirmation";
    }
}
