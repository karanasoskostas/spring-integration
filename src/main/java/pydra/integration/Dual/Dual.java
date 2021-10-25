package pydra.integration.Dual;


import javax.persistence.*;

@Entity
@Table(name="dual")
public class Dual {

    @Id
    @Column(name = "dummy")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dual() {
    }
}
