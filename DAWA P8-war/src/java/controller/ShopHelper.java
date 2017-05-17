package controller;

import cart.CDProduct;
import cart.ShopLine;
import cart.ejb.ShoppingCart;
import cart.ejb.ShoppingCartLocal;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;

public class ShopHelper {    
    private ShoppingCartLocal shoppingCart;

    public ShopHelper(ShoppingCartLocal shoppingCart) {
        this.shoppingCart = shoppingCart;
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
}