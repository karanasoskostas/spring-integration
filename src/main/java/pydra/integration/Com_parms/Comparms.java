package pydra.integration.Com_parms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="com_parms")
public class Comparms {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="gsisafmcode")
    private String gsisafmcode;

    @Column(name="gsisspecialcode")
    private String gsispecialcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGsisafmcode() {
        return gsisafmcode;
    }

    public void setGsisafmcode(String gsisafmcode) {
        this.gsisafmcode = gsisafmcode;
    }

    public String getGsispecialcode() {
        return gsispecialcode;
    }

    public void setGsispecialcode(String gsispecialcode) {
        this.gsispecialcode = gsispecialcode;
    }

    public Comparms() {
    }
}
