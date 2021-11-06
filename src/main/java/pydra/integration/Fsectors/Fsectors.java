package pydra.integration.Fsectors;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="ydr_fsectors")
public class Fsectors {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "sect_code")
    private Long id;

    @Column(name = "sect_descr")
    private String sectdescr;

    @Column(name = "sect_periods")
    private Long periods;

    public Long getId() {
        return id;
    }

    public String getSectdescr() {
        return sectdescr;
    }

    public Long getPeriods() {
        return periods;
    }
}
