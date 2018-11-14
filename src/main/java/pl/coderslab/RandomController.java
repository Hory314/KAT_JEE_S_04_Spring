package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController
{
    @RequestMapping("/random")
    @ResponseBody
    public String showRandom()
    {
        Random generator = new Random();

        return "" + (generator.nextInt(100) + 1);
    }

    @RequestMapping("/random/{max}")
    @ResponseBody
    public String randomMax(@PathVariable int max)
    {
        Random generator = new Random();
        return "" + (generator.nextInt(max) + 1);
    }

    @RequestMapping("/random/{min}/{max}")
    @ResponseBody
    public String randomMax(@PathVariable int max, @PathVariable("min") int min)
    {
        Random generator = new Random();
        return "" + (generator.nextInt((max - min + 1) + min));
    }
}
