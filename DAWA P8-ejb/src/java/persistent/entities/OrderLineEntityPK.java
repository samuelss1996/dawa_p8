package persistent.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class OrderLineEntityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "orderId")
    private int orderId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "lineNumber")
    private int lineNumber;

    public OrderLineEntityPK() {
    }

    public OrderLineEntityPK(int orderId, int lineNumber) {
        this.orderId = orderId;
        this.lineNumber = lineNumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderId;
        hash += (int) lineNumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderLineEntityPK)) {
            return false;
        }
        OrderLineEntityPK other = (OrderLineEntityPK) object;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.lineNumber != other.lineNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistent.entities.OrderLineEntityPK[ orderId=" + orderId + ", lineNumber=" + lineNumber + " ]";
    }
}