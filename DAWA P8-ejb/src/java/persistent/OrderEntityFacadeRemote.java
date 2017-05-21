package persistent;

import javax.ejb.Remote;
import persistent.entities.OrderEntity;

@Remote
public interface OrderEntityFacadeRemote {
    void insert(OrderEntity orderEntity);
}