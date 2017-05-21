package persistent;

import javax.ejb.Local;
import persistent.entities.OrderEntity;

@Local
public interface OrderEntityFacadeLocal {
    void insert(OrderEntity orderEntity);
}
