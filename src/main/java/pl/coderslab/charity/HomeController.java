package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Repository.DonationRepository;
import pl.coderslab.charity.Repository.InstitutionRepository;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutionList", institutionRepository.findAll());
        List<Donation> donations = donationRepository.findAll();
        Integer bagQuantity=0;
        Integer donationsQuantity=0;
        for ( Donation donation:donations){
            bagQuantity  += donation.getQuantity();
            donationsQuantity += 1;        }
        model.addAttribute("bagQuantity", bagQuantity);
        model.addAttribute("donationsQuantity", donationsQuantity);
        return "homepage/index";
    }


}


