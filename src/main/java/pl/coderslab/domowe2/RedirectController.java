package pl.coderslab.domowe2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController
{
    @RequestMapping("/dom2first")
    public String first()
    {

        return "dom2first";
    }

    @RequestMapping("/dom2third")
    public String third()
    {

        return "dom2third";
    }

    @RequestMapping("/dom2second")
    public String second()
    {

        return "redirect:dom2third";
    }
}
