package at.htl.service;

import at.htl.model.Grave;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class GraveService {
    @Inject
    private EntityManager em;

    public Grave  getWithFetchType (){
        return em.find(Grave.class,1L);
    }

    public Grave getWithEntityGraph(){
        EntityGraph entityGraph = em.getEntityGraph("grave-entity-graph");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        return em.find(Grave.class, 1L, properties);
    }
}
