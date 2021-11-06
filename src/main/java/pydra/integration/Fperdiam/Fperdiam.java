package pydra.integration.Fperdiam;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ydr_fperdiam")
@Getter
@Setter
public class Fperdiam {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "rpdiam_code")
    private Long id;

//
    @Column(name = "RPDIAM_descr")
    private String diamdescr;

    public String getDiamdescr() {
        return diamdescr;
    }


}
