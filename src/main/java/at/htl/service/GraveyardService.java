package at.htl.service;

import at.htl.model.Graveyard;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GraveyardService {

    @Inject
    private EntityManager em;

    public List<Graveyard> getAll(){
        return em.createNamedQuery("Graveyard.findall",Graveyard.class).getResultList();
    }

    public List<Graveyard> get(String location){
        return em.createNamedQuery("Graveyard.findByLocation",Graveyard.class).setParameter("location",location).getResultList();
    }

    public void delete(long id){
        System.out.println(id);
        Graveyard g = em.find(Graveyard.class,id);
        System.out.println(g.getId() + g.getLocation() + g.getArea() + g.getNumberOfGraves());
        em.remove(g);
    }
    public void update(Graveyard g){
        em.merge(g);
    }

    public void add(Graveyard g){
        em.persist(g);
    }
}
