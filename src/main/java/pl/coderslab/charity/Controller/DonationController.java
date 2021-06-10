package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Repository.CategoryRepository;
import pl.coderslab.charity.Repository.DonationRepository;
import pl.coderslab.charity.Repository.InstitutionRepository;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @GetMapping("/add")
    public String addDonation(Model model ) {
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("institution",institutionRepository.findAll());
        model.addAttribute("donation", new Donation());
        return "donation/form";
    }

    @PostMapping("/add")
    public String addDonationPost(@Valid Donation donation,BindingResult result){
        donationRepository.save(donation);
        return "donation/form";
    }
}
