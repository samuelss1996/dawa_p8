package cart.ejb;

import cart.ShopLine;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ShoppingCartRemote {
    void add(ShopLine shopLine);
    void remove(int index);
    void clear();
    List<ShopLine> getShopLineList();
    float getTotalPrice();
}