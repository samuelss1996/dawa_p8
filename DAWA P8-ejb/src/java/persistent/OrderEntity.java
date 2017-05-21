/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ada
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderEntity.findAll", query = "SELECT o FROM OrderEntity o")
    , @NamedQuery(name = "OrderEntity.findById", query = "SELECT o FROM OrderEntity o WHERE o.id = :id")
    , @NamedQuery(name = "OrderEntity.findByCustomerName", query = "SELECT o FROM OrderEntity o WHERE o.customerName = :customerName")
    , @NamedQuery(name = "OrderEntity.findByCustomerEmail", query = "SELECT o FROM OrderEntity o WHERE o.customerEmail = :customerEmail")
    , @NamedQuery(name = "OrderEntity.findByTotalPrice", query = "SELECT o FROM OrderEntity o WHERE o.totalPrice = :totalPrice")})
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "customerName")
    private String customerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "customerEmail")
    private String customerEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPrice")
    private float totalPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderEntity")
    private Collection<OrderLineEntity> orderLineEntityCollection;

    public OrderEntity() {
    }

    public OrderEntity(Integer id) {
        this.id = id;
    }

    public OrderEntity(Integer id, String customerName, String customerEmail, float totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @XmlTransient
    public Collection<OrderLineEntity> getOrderLineEntityCollection() {
        return orderLineEntityCollection;
    }

    public void setOrderLineEntityCollection(Collection<OrderLineEntity> orderLineEntityCollection) {
        this.orderLineEntityCollection = orderLineEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderEntity)) {
            return false;
        }
        OrderEntity other = (OrderEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistent.OrderEntity[ id=" + id + " ]";
    }
    
}
