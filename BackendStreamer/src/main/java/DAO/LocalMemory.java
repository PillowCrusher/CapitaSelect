package DAO;

import Entity.Donation;
import Entity.Roster;

import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class LocalMemory {
    private Roster roster;
    private List<Donation> donationList;
}
