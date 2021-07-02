package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.MessageService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    @RequestMapping("/send")
    public String sendEmail(@RequestParam String name, @RequestParam String surname, @RequestParam String message) {
        String messageContent = name+" "+surname+" "+" przesyła wiadomość: "+message;
        messageService.sendEmail(messageContent);
        return "redirect:/";
    }
}
