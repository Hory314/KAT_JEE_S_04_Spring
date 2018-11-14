package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProduktDao
{
    private List<Product> list;

    public List<Product> getList()
    {
        list = new ArrayList<>();
        list.add(new Product(new Long(1),"maslo", 1343.0));
        list.add(new Product(new Long(2),"chleb", 1343.0));
        list.add(new Product(new Long(3),"melko", 1343.0));
        list.add(new Product(new Long(4),"budyń", 2133.0));
        list.add(new Product(new Long(5),"woda", 113.0));
        list.add(new Product(new Long(6),"kawa", 132.0));
        list.add(new Product(new Long(7),"kiwi", 143.0));
        list.add(new Product(new Long(8),"ser", 143.0));
        list.add(new Product(new Long(9),"chipsy", 4.5));
        list.add(new Product(new Long(10),"laptop", 1335.0));
        return list;
    }
}
