package pydra.integration.Fperdiak;

import org.hibernate.annotations.Cascade;
import pydra.integration.Fdiakopes.Fdiakopes;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="Ydr_Fperdiak")
public class Fperdiak {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "rpdiak_code")
    private Long id;

    @Column(name="rpdiak_descr")
    private String rpdiakdescr;


    public Fperdiak() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRpdiakdescr() {
        return rpdiakdescr;
    }

    public void setRpdiakdescr(String rpdiakdescr) {
        this.rpdiakdescr = rpdiakdescr;
    }

    @Override
    public String toString() {
        return "Fperdiak{" +
                "id=" + id +
                ", rpdiakdescr='" + rpdiakdescr + '\'' +
                '}';
    }
}
