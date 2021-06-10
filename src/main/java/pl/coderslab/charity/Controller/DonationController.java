package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.Donation;

@Controller
@RequiredArgsConstructor
@RequestMapping("/donation")
public class DonationController {

    @GetMapping("/add")
    public String addDonation(Model model ) {
        model.addAttribute("donation", new Donation());
        return "donation/form";
    }
}
