package pl.coderslab;

public class Product
{
    private String name;
    private Double price;
    private Long id;

    public Product()
    {
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Product(Long id, String name, double price)
    {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

}
