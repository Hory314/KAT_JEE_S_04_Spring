package pl.coderslab.domowe2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class HelloController2
{
    @RequestMapping("/workers")
    public String workersAction(Model model, HttpServletRequest request)
    {
        Random generator = new Random();
        int randId = generator.nextInt(30) + 1;

        String generatedPerson = getPersonById(randId);

        model.addAttribute("generatedPerson", generatedPerson);
        return "workers";
    }

    private String getPersonById(int randId)
    {
        Path path = Paths.get("E:\\Hory\\workspace\\KAT_JEE_S_04_Spring\\src\\main\\java\\pl\\coderslab\\domowe2\\Workers.txt");
        // todo jaki relative path???

        try
        {
            return Files.readAllLines(path).stream().map(line ->
            {
                if (line.substring(0, 1).equals(0 + ""))
                {
                    return line.substring(1);
                }
                return line;
            }).filter(line -> (line.startsWith("" + randId))).limit(1).collect(Collectors.joining(""));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "";
        }
    }
}
