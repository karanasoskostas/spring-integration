package pydra.integration.Fperbla;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ydr_fperbla")
public class Fperbla {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "rpbla_code")
    private Long id;

    @Column(name="rpbla_descr")
    private String rpdiakdescr;

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

    public Fperbla() {
    }


}
