package persistent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistent.entities.OrderEntity;

@Stateless
public class OrderEntityFacade implements OrderEntityFacadeLocal, OrderEntityFacadeRemote {
    @PersistenceContext(unitName = "DAWA_P8-ejbPU")
    private EntityManager entityManager;

    @Override
    public void insert(OrderEntity entity) {
        this.entityManager.persist(entity);
    }
}