package pl.coderslab;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/first", produces = "text/html; charset=UTF-8")
public class FreeTimeController
{
    @RequestMapping(value = "/freetime", produces = "text/html; charset=UTF-8") // post i get
    @ResponseBody
    public String freeTime()
    {
        LocalDateTime now = LocalDateTime.now();
        int currentWeek = now.getDayOfWeek().getValue();

        if (currentWeek >= 6) // sobota niedziela
        {
            return "Wolne";
        }
        else
        {
            int currentHour = now.getHour();
            if (currentHour >= 9 && currentHour <= 17)
            {
                return "Pracuje, nie dzwoń.";
            }
            else
            {
                return "Po pracy";
            }
        }
    }


    @GetMapping(value = "/form", produces = "text/html; charset=UTF-8")
    public String formularz(HttpServletRequest request)
    {
        return "form";
    }

    @PostMapping(value = "/form", produces = "text/html; charset=UTF-8")
    public String formularz2(Model model, @RequestParam String paramName, HttpServletRequest request)
    {
        model.addAttribute("pName", paramName);
        return formularz(request);

    }

}
