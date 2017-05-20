package cart;

public class ShopLine {
    private CDProduct product;
    private Integer quantity;
    private Float totalPrice;

    public ShopLine(CDProduct product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;

        this.totalPrice = product.getPrice() * quantity;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
        this.totalPrice += quantity * this.product.getPrice();
    }

    public CDProduct getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopLine shopLine = (ShopLine) o;

        return product != null ? product.equals(shopLine.product) : shopLine.product == null;
    }

    @Override
    public int hashCode() {
        return product != null ? product.hashCode() : 0;
    }
}