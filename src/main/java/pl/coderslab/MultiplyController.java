package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MultiplyController
{
    @RequestMapping("/multiply/{size}")
    public String multiply(Model model, @PathVariable int size)
    {
        if (size > 100) size = 100;
        if (size < 0) size = 0;
        model.addAttribute("rows", size);
        model.addAttribute("cols", size);
        return "multiplytable";
    }

    @RequestMapping("/multiply/{rows}/{cols}")
    public String multiply(Model model, @PathVariable int rows, @PathVariable int cols)
    {
        if (rows > 100) rows = 100;
        if (cols > 100) cols = 100;
        if (rows < 0) rows = 0;
        if (cols < 0) cols = 0;
        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);
        return "multiplytable";
    }
}
