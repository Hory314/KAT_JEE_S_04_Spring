package pl.coderslab.dodatkowe1.Entity;

public class Drink
{
    private Integer id;
    private String name;
    private Double vol;
    private String description;
    private Category category;

    public Drink()
    {
    }

    public Drink(Integer id, String name, Double vol, String description, Category category)
    {
        this.id = id;
        this.name = name;
        this.vol = vol;
        this.description = description;
        this.category = category;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
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

    public Double getVol()
    {
        return vol;
    }

    public void setVol(Double vol)
    {
        this.vol = vol;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }
}
