package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController
{
    @RequestMapping("/setcookie/{value1}/{value2}")
    @ResponseBody
    public String cookieSet(@PathVariable String value1, @PathVariable String value2, HttpServletResponse response)
    {
        Cookie cookie1 = new Cookie("cookie1", value1);
        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "ustawiono ciasteczka";
    }

    @RequestMapping("/getcookies")
    @ResponseBody
    public String cookieGet(HttpServletRequest request, @CookieValue("cookie2") String cookie2Val)
    {
        StringBuilder result = new StringBuilder();
        Cookie cookie1 = WebUtils.getCookie(request, "cookie1");
        result.append(cookie1.getName()).append(" : ").append(cookie1.getValue()).append("\n");
        result.append("Wartosc dugiego ciasteczka: ").append(cookie2Val);

        return result.toString();
    }

}
