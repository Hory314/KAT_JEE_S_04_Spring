package pl.coderslab.dodatkowe1.Entity;

public class Category
{
    private Integer id;
    private String name;

    public Category()
    {
    }

    public Category(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
