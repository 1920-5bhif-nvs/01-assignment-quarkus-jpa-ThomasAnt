package at.htl.model;
import at.htl.model.Graveyard;

import javax.persistence.*;

@NamedEntityGraph(
        name = "grave-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("familyName"),
                @NamedAttributeNode("graveyard"),
        }
)
@Entity
public class Grave{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String familyName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Graveyard graveyard;


    public Grave() {
    }

    public Grave(String name,Graveyard g){
        this.familyName = name;
        this.graveyard = g;
    }

    public Long getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Graveyard getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(Graveyard graveyard) {
        this.graveyard = graveyard;
    }
}
