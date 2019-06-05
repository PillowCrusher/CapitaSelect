package Dao;

import Entity.BattleBro;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Stateful
public class BroDao {
    @PersistenceContext(unitName = "capitaSelectGameBackend")
    private EntityManager entityManager;

    private String getId() {
        return UUID.randomUUID().toString();
    }

    public BattleBro findByName(String name) {
      BattleBro bro = entityManager.createNamedQuery("BattleBro.findByName",BattleBro.class)
                .setParameter("name",name)
                .getSingleResult();
      return bro;
    }

    public BattleBro findById(String id) {
        BattleBro bro = entityManager.createNamedQuery("BattleBro.findById",BattleBro.class)
                .setParameter("id",id)
                .getSingleResult();
        return bro;
    }

    public void createBro(BattleBro battleBro) {
        entityManager.persist(battleBro);
    }

    public void deleteBro(BattleBro battleBro) {
        entityManager.remove(battleBro);
    }

    public void updateBro(BattleBro battleBro) {
        entityManager.merge(battleBro);
    }
}