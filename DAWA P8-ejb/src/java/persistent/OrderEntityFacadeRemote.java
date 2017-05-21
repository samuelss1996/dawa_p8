package persistent;

import java.util.List;
import javax.ejb.Remote;
import persistent.entities.OrderEntity;

@Remote
public interface OrderEntityFacadeRemote {
    void create(OrderEntity orderEntity);
    void edit(OrderEntity orderEntity);
    void remove(OrderEntity orderEntity);
    OrderEntity find(Object id);
    List<OrderEntity> findAll();
    List<OrderEntity> findRange(int[] range);
    int count();
}