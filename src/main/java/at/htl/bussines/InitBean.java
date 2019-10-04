package at.htl.bussines;

import at.htl.model.Graveyard;
import io.quarkus.runtime.StartupEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Console;

public class InitBean {
    @Inject
    EntityManager em;

    @Transactional
    void init(@Observes StartupEvent ev){
        System.out.println("Init");
        Graveyard graveyard = new Graveyard(100,"Linz",10);
        em.persist(graveyard);
        Graveyard graveyard2 = new Graveyard(200,"Leonding",20);
        em.persist(graveyard2);
    }
}
