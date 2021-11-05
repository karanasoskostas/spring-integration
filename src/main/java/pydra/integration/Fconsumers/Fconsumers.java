package pydra.integration.Fconsumers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import pydra.integration.Fperdiak.Fperdiak;
import pydra.integration.Fpersons.Fpersons;
import pydra.integration.Snd_genpar.Sndgenpar;

import javax.persistence.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

@Getter
@Setter
@Entity
@Table(name="ydr_fconsumers")
public class Fconsumers {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "id")
    private Long id;


    @Column(name = "rma_code")
    private String code;

    @Column(name = "rma_ydrom")
    private String ydrometro;

    @Column(name = "emr")
    private Integer emr;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="rma_liable_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Fpersons liable;

    @Column(name = "rma_liable_id")
    private Long liable_id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="rma_owner_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Fpersons owner;

    @Column(name = "rma_owner_id")
    private Long owner_id;

    @Transient
    private String liablename;

    @Transient
    private String liableafm;

    @Transient
    private String liableadt;


    @Transient
    private String diadromhformat;

    public void setDiadromhformat(String diadromhformat) {
        this.diadromhformat = diadromhformat;
    }

    public Fpersons getLiable() {
        return liable;
    }

    public Fpersons getOwner() {
        return liable;
    }


    public String getLiablename() {
        return getLiable().getName();
    }

    public String getLiableafm() {
        return getLiable().getAfm();
    }

    public String getLiableadt() {
        return getLiable().getAdt();
    }


    public String getCode() throws ParseException {
        MaskFormatter formatter = new MaskFormatter(this.diadromhformat);
        formatter.setValueContainsLiteralCharacters(false);
        code = formatter.valueToString(code);
        return code;
    }

    public Fconsumers() {
    }

}
