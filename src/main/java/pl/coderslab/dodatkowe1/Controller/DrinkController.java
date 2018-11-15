package pl.coderslab.dodatkowe1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dodatkowe1.Dao.CategoryDao;
import pl.coderslab.dodatkowe1.Dao.DrinkDao;
import pl.coderslab.dodatkowe1.Entity.Drink;

@Controller
public class DrinkController
{
    private final DrinkDao drinkDao;
    private final CategoryDao categoryDao;

    @Autowired // ta adnotacja niewymagana jeśli jest 1 konstruktor w tej klasie
    public DrinkController(DrinkDao drinkDao, CategoryDao categoryDao)
    {
        this.drinkDao = drinkDao;
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/drinks")
    public String listAll(Model model)
    {
        model.addAttribute("drinks", drinkDao.getAll());
        return "drink/list";
    }

    @RequestMapping("/drinks/{id}")
    public String listOne(Model model, @PathVariable int id)
    {
        try
        {
            model.addAttribute("drink", drinkDao.getById(id));
            model.addAttribute("exist", true);
        }
        catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
            model.addAttribute("exist", false);
        }
        return "drink/detail";
    }

    @GetMapping("/drinks/add")
    public String addGet(Model model)
    {
        model.addAttribute("categories", this.categoryDao.getAll());
        return "drink/add";
    }

    @PostMapping("/drinks/add") // obsluguje tez edycje
    public String addPost(Model model,
                          @RequestParam String name,
                          @RequestParam Double vol,
                          @RequestParam String description,
                          @RequestParam int category_id,
                          @RequestParam String id)
    {
        Integer intId;
        try
        {
            intId = Integer.parseInt(id);
        }
        catch (NumberFormatException e)
        {
            intId = null;  // jak hidden name="", to wtedy null i wiemy ze dodajemy (a nie update)
        }

        // jakiś try-catch mógłby być w razie W
        Drink drink = new Drink();
        drink.setId(intId);
        drink.setName(name);
        drink.setVol(vol);
        drink.setDescription(description);
        drink.setCategory(this.categoryDao.getById(category_id));

        drinkDao.save(drink);

        model.addAttribute("exist", true);
        return "redirect:add";
    }

    @RequestMapping("/drinks/delete/{id}")
    public String delete(@PathVariable int id)
    {
        drinkDao.delete(id);
        return "redirect:/drinks";
    }

    @GetMapping("/drinks/edit/{id}")
    public String editGet(Model model, @PathVariable int id)
    {
        try
        {
            model.addAttribute("drink", this.drinkDao.getById(id));
            model.addAttribute("categories", this.categoryDao.getAll());
            model.addAttribute("exist", true);
        }
        catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
            model.addAttribute("exist", false);
        }
        return "drink/add"; // widok ten sam co do dodawania
    }
}
