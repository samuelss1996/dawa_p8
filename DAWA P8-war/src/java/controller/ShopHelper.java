package controller;

import cart.CDProduct;
import cart.ShopLine;
import cart.ejb.ShoppingCart;
import cart.ejb.ShoppingCartLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShopHelper {    
    private final ShoppingCartLocal shoppingCart;

    public ShopHelper(HttpSession session) {        
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
    
    // TODO
    public void finishShopCart(String userName, String userEmail) {
//        User user = new User();
//        user.setName(userName);
//        user.setEmail(userEmail);
//
//        this.session.setAttribute("user", user);
    }
    
    // TODO
    public void finishShopping() {
//        ShopCart shopCart = (ShopCart) this.session.getAttribute("shopCart");
//        User user = (User) this.session.getAttribute("user");
//
//        OrdersDao.getInstance().insertOrder(shopCart, user);

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
        cdProduct.setPrize(Float.valueOf(matcher.group(4)));

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
}