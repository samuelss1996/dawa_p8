/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent;

import java.util.List;
import javax.ejb.Local;
import persistent.entities.OrderEntity;

/**
 *
 * @author Ada
 */
@Local
public interface OrderEntityFacadeLocal {
    void create(OrderEntity orderEntity);
    void edit(OrderEntity orderEntity);
    void remove(OrderEntity orderEntity);
    OrderEntity find(Object id);
    List<OrderEntity> findAll();
    List<OrderEntity> findRange(int[] range);
    int count();
}
