package pl.coderslab.dodatkowe1.Dao;

import org.springframework.stereotype.Component;
import pl.coderslab.dodatkowe1.Entity.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class CategoryDao
{
    private List<Category> categories;

    public CategoryDao()
    {
        init();
    }

    private void init()
    {
        this.categories = new ArrayList<>();
        this.categories.add(new Category(1, "Dla kobiet"));
        this.categories.add(new Category(2, "Mocne"));
        this.categories.add(new Category(3, "Koktajle"));
        this.categories.add(new Category(4, "Bezalkoholowe"));
        this.categories.add(new Category(5, "Z palemką"));
    }

    public List<Category> getAll()
    {
        return categories;
    }

    public Category getById(int id)
    {
        try
        {
            return/*Category category =*/ this.categories.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
            return null;
        }
    }
}
