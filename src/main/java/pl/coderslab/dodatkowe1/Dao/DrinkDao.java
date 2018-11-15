package pl.coderslab.dodatkowe1.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.dodatkowe1.Entity.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DrinkDao
{
    private List<Drink> drinks;
    private int autoincrement;
    private final CategoryDao categoryDao;

    @Autowired // niekonieczne bo 1 konstruktor
    public DrinkDao(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
        init();
    }

    private void init()
    {
        this.autoincrement = 0;
        this.drinks = new ArrayList<>();

        //testing drinks
        this.save(new Drink(null, "Malibu", 14.4, "Super drink malibu", categoryDao.getById(1)));
        this.save(new Drink(null, "Martini", 15.1, "Super drink martini", categoryDao.getById(2)));
        this.save(new Drink(null, "Wódka z Colą", 28.4, "Super drink wóda", categoryDao.getById(3)));
        this.save(new Drink(null, "Sex on the beach", 18.2, "Super drink sex otb", categoryDao.getById(4)));
        this.save(new Drink(null, "Wściekły pies", 35.0, "Super drink wściekły pies", categoryDao.getById(5)));
    }

    public List<Drink> getAll()
    {
        return drinks;
    }

    public Drink getById(int id) throws IndexOutOfBoundsException, NullPointerException
    {
        try
        {
            return this.drinks.stream().filter(d -> d.getId() == id).collect(Collectors.toList()).get(0);
        }
        catch (NullPointerException | IndexOutOfBoundsException e)
        {
            e.printStackTrace();
            throw e; // niech się dalej ktoś martwi ;>
        }
    }

    public void save(Drink drink)
    {
        if (drink.getId() == null)
        {
            add(drink);
        }
        else
        {
            update(drink);
        }
    }

    private void update(Drink drink)
    {
        int indexOfOldEl = this.drinks.indexOf(this.getById(drink.getId()));
        this.drinks.set(indexOfOldEl, drink);
    }

    private void add(Drink drink)
    {
        drink.setId(++autoincrement);
        this.drinks.add(drink);
    }

    public void delete(int id)
    {
        this.drinks.removeIf(d -> d.getId() == id);
    }
}
