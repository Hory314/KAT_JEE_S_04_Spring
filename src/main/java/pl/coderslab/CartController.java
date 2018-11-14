package pl.coderslab;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class CartController
{
    @Autowired
    private final Cart cart; // wskrzyknięcie (Spring załatwia mi obiekt) Mozna tez przez Konstruktor i setter (+@autowired)
    @Autowired
    private final ProduktDao produktDao;


    public CartController(Cart cart, ProduktDao produktDao)
    {
        this.cart = cart;
        this.produktDao = produktDao;
    }

    @RequestMapping("/addtocart/{id}")
    @ResponseBody
    public String addtocart(@PathVariable int id)
    {

        List<CartItem> cartItems = this.cart.getCartItems();
        for (CartItem item : cartItems)
        {
            if (item.getProduct().getId() == id)
            {
                item.setQuantity(item.getQuantity() + 1);
                return "zwiekszono";
            }
        }

        cart.addToCart(new CartItem(1, produktDao.getList().get(id - 1)));


        return "dodano nowy";
    }

    @RequestMapping("/cart")
    @ResponseBody
    public String cart()
    {
        List<CartItem> cartItems = this.cart.getCartItems();
        String cart = cartItems.stream().map(i -> i.toString()).collect(Collectors.joining(","));
        StringBuilder sb = new StringBuilder(cart);
        sb.append("\nPozycji w koszyku: ").append(cartItems.size());
        sb.append("\nWszystkich produktów: ").append(cartItems.stream().mapToInt(el -> el.getQuantity()).sum());
        sb.append("\nDo zapłąty: ").append(cartItems.stream().mapToDouble(el -> (el.getQuantity() * el.getProduct().getPrice())).sum());
        return sb.toString();
    }
}
