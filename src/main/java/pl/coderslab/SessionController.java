package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class SessionController
{
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpSession session)
    {
        if (session.getAttribute("loginStart") == null)
        {
            session.setAttribute("loginStart", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            return "wstawiam...";
        }
        else
        {
            return "login start: "+ (String) session.getAttribute("loginStart");
        }
    }
}
