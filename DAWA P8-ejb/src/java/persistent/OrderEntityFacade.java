/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistent.entities.OrderEntity;

/**
 *
 * @author Ada
 */
@Stateless
public class OrderEntityFacade implements OrderEntityFacadeLocal, OrderEntityFacadeRemote {
    @PersistenceContext(unitName = "DAWA_P8-ejbPU")
    private EntityManager entityManager;

    @Override
    public void insert(OrderEntity entity) {
        this.entityManager.persist(entity);
    }
}