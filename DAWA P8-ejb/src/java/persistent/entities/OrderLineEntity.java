package persistent.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "order_line")
public class OrderLineEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected OrderLineEntityPK orderLineEntityPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "artist")
    private String artist;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "country")
    private String country;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "unitPrice")
    private float unitPrice;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPrice")
    private float totalPrice;
    
    @JoinColumn(name = "orderId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrderEntity orderEntity;

    public OrderLineEntity() {
    }

    public OrderLineEntity(OrderLineEntityPK orderLineEntityPK, String title, String artist, String country, float unitPrice, int quantity, float totalPrice) {
        this.orderLineEntityPK = orderLineEntityPK;
        this.title = title;
        this.artist = artist;
        this.country = country;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public OrderLineEntity(int orderId, int lineNumber) {
        this.orderLineEntityPK = new OrderLineEntityPK(orderId, lineNumber);
    }

    public OrderLineEntityPK getOrderLineEntityPK() {
        return orderLineEntityPK;
    }

    public void setOrderLineEntityPK(OrderLineEntityPK orderLineEntityPK) {
        this.orderLineEntityPK = orderLineEntityPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderLineEntityPK != null ? orderLineEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderLineEntity)) {
            return false;
        }
        OrderLineEntity other = (OrderLineEntity) object;
        if ((this.orderLineEntityPK == null && other.orderLineEntityPK != null) || (this.orderLineEntityPK != null && !this.orderLineEntityPK.equals(other.orderLineEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistent.entities.OrderLineEntity[ orderLineEntityPK=" + orderLineEntityPK + " ]";
    }
}