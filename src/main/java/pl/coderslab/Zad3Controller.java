package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class Zad3Controller
{
    @RequestMapping("/helloview")
    public String helloview(Model model)
    {
        LocalDateTime now = LocalDateTime.now();
        int currentHour = now.getHour();

        if (currentHour >= 8 && currentHour <= 20)
        {
            model.addAttribute("color", "black");
            model.addAttribute("bgColor", "yellow");
        }
        else
        {
            model.addAttribute("color", "white");
            model.addAttribute("bgColor", "navy");
        }

        return "home";
    }
}
