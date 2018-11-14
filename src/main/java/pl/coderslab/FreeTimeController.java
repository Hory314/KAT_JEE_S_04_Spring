package pl.coderslab;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class FreeTimeController
{
    @RequestMapping("/freetime") // post i get
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
}
