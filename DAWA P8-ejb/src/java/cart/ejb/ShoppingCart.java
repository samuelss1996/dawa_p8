package cart.ejb;

import cart.ShopLine;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

@Stateful(name = "ShoppingCart")
public class ShoppingCart implements ShoppingCartLocal, ShoppingCartRemote {
    private final List<ShopLine> shopLineList;
    private float totalPrice;

    public ShoppingCart() {
        this.shopLineList = new ArrayList<>();
        this.totalPrice = 0f;
    }
    
    @Override
    public void add(ShopLine shopLine) {
        if(this.shopLineList.contains(shopLine)) {
            this.shopLineList.get(this.shopLineList.indexOf(shopLine)).addQuantity(shopLine.getQuantity());
        } else {
            this.shopLineList.add(shopLine);
        }

        this.totalPrice += shopLine.getTotalPrice();
    }

    @Override
    public void remove(int index) {
        ShopLine shopLine = this.shopLineList.get(index);

        this.shopLineList.remove(index);
        this.totalPrice -= shopLine.getTotalPrice();
    }

    @Override
    public void clear() {
        this.shopLineList.clear();
        this.totalPrice = 0f;
    }

    @Override
    public List<ShopLine> getShopLineList() {
        return shopLineList;
    }

    @Override
    public float getTotalPrice() {
        return totalPrice;
    }
}