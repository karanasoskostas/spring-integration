package pydra.integration.Fconsumers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pydra.integration.Fperdiak.Fperdiak;
import pydra.integration.Fpersons.Fpersons;

import javax.persistence.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="rma_liable_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Fpersons liable;

    @Column(name = "rma_liable_id")
    private Long liable_id;


    @Transient
    private String liablename;

    @Transient
    private String liableafm;

    @Transient
    private String liableadt;


    public String getLiablename() {
        return getLiable().getName();
    }

    public String getLiableafm() {
        return getLiable().getAfm();
    }

    public String getLiableadt() {
        return getLiable().getAdt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYdrometro() {
        return ydrometro;
    }

    public void setYdrometro(String ydrometro) {
        this.ydrometro = ydrometro;
    }

    public Fpersons getLiable() {
        return liable;
    }

    public void setLiable(Fpersons liable) {
        this.liable = liable;
    }

    public String getCode() throws ParseException {
        MaskFormatter formatter = new MaskFormatter("AAAAA-AAAA");
        formatter.setValueContainsLiteralCharacters(false);
        code = formatter.valueToString(code);
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getLiable_id() {
        return liable_id;
    }

    public void setLiable_id(Long liable_id) {
        this.liable_id = liable_id;
    }

    public void setLiablename(String liablename) {
        this.liablename = liablename;
    }

    public Fconsumers() {
    }
}
