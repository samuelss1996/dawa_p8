package controller;

import cart.CDProduct;
import cart.ShopLine;
import cart.User;
import cart.ejb.ShoppingCartLocal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import persistent.OrderEntityFacadeLocal;
import persistent.entities.OrderEntity;
import persistent.entities.OrderLineEntity;
import persistent.entities.OrderLineEntityPK;

public class ShopHelper {    
    private final HttpSession session;
    private final ShoppingCartLocal shoppingCart;

    public ShopHelper(HttpSession session) {        
        this.session = session;
        
        if(session.getAttribute("shoppingCart") != null) {
            this.shoppingCart = (ShoppingCartLocal) session.getAttribute("shoppingCart");
        } else {
            this.shoppingCart = this.lookupShoppingCartLocal();
            session.setAttribute("shoppingCart", this.shoppingCart);
        }
    }

    public void addToCart(String productString, Integer quantity) {       
        this.shoppingCart.add(new ShopLine(this.parseProductString(productString), quantity));
    }

    public void removeFromCart(Integer index) {
        this.shoppingCart.remove(index);
    }
    
    public void finishShopCart(String userName, String userEmail) {
        User user = new User();
        user.setName(userName);
        user.setEmail(userEmail);

        this.session.setAttribute("user", user);
    }
    
    public void finishShopping(OrderEntityFacadeLocal orderFacade) {
        User user = (User) this.session.getAttribute("user");
        orderFacade.insert(this.createOrder(this.shoppingCart, user));
           
        this.shoppingCart.clear();
    }

    private CDProduct parseProductString(String productString) {
        Pattern regexPattern = Pattern.compile("(.*) \\| (.*) \\| (.*) \\| \\$(.*)");
        Matcher matcher = regexPattern.matcher(productString);
        matcher.find();

        CDProduct cdProduct = new CDProduct();

        cdProduct.setTitle(matcher.group(1));
        cdProduct.setArtist(matcher.group(2));
        cdProduct.setCountry(matcher.group(3));
        cdProduct.setPrice(Float.valueOf(matcher.group(4)));

        return cdProduct;
    }
    
    private ShoppingCartLocal lookupShoppingCartLocal() {
        try {
            Context c = new InitialContext();
            return (ShoppingCartLocal) c.lookup("java:global/DAWA_P8/DAWA_P8-ejb/ShoppingCart!cart.ejb.ShoppingCartLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private OrderEntity createOrder(ShoppingCartLocal shoppingCart, User user) {
        OrderEntity order = new OrderEntity();
        
        order.setCustomerName(user.getName());
        order.setCustomerEmail(user.getEmail());
        order.setTotalPrice(shoppingCart.getTotalPrice());
        
        ArrayList<OrderLineEntity> orderLines = new ArrayList();
        
        for(int i = 0; i < shoppingCart.getShopLineList().size(); i++) {
            ShopLine line = shoppingCart.getShopLineList().get(i);
            
            orderLines.add(new OrderLineEntity(new OrderLineEntityPK(-1, i), line.getProduct().getTitle(), line.getProduct().getArtist(),
                    line.getProduct().getCountry(), line.getProduct().getPrice(), line.getQuantity(), line.getTotalPrice()));
        }
        
        order.setOrderLineEntityList(orderLines);
        
        return order;
    }
}