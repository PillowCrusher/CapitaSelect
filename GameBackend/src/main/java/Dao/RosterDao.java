package Dao;

import Entity.Roster;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class RosterDao {
    @PersistenceContext(unitName = "capitaSelectGameBackend")
    private EntityManager entityManager;

    public Roster getCurrentRoster(){
        return entityManager.createNamedQuery("Roster.get",Roster.class)
                .getSingleResult();
    }

    public void updateRoster(Roster roster) {
        entityManager.merge(roster);
    }

    public void createRoster(Roster roster) {
        entityManager.createNamedQuery("Roster.removeAll",Roster.class);
        entityManager.persist(roster);
    }
}
