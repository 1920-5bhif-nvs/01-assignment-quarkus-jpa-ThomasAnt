package at.htl.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Graveyard.findall",query = "Select g from Graveyard g"),
        @NamedQuery(name = "Graveyard.findByLocation",query = "SELECT g from Graveyard g where g.location=:location")
})

public class Graveyard {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Long area;
    private String location;
    private Long numberOfGraves;

    public Graveyard(long area, String location, long numberOfGraves) {
        this.area = area;
        this.location = location;
        this.numberOfGraves = numberOfGraves;
    }

    public Graveyard() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getNumberOfGraves() {
        return numberOfGraves;
    }

    public void setNumberOfGraves(long numberOfGraves) {
        this.numberOfGraves = numberOfGraves;
    }
}
