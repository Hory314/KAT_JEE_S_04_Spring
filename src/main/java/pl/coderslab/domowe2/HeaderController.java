package pl.coderslab.domowe2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController
{
    @RequestMapping("/showUserAgent")

    public String showUserAgent(Model model, @RequestHeader("user-agent") String userUserAgent)
    {
        model.addAttribute("userUserAgent",userUserAgent);
        return "userAgent";
    }
}
