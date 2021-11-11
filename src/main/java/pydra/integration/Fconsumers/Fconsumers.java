package pydra.integration.Fconsumers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pydra.integration.Faddress.Faddress;
import pydra.integration.Fperdiam.Fperdiam;
import pydra.integration.Fpersons.Fpersons;
import pydra.integration.Fsectors.Fsectors;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="RMA_DIAM_AGOG", referencedColumnName = "rpdiam_code", updatable = false, insertable = false)
    private Fperdiam fperdiam;

    @Column(name="latitude")
    private String latitude;

    @Column(name="longitude")
    private String longitude;

    @Column(name="RMA_ADDR_ODOS_AKIN")
    private String addr_odos_akin;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="rma_tomeas", referencedColumnName = "sect_code", updatable = false, insertable = false)
    private Fsectors sector;

    public Fperdiam getFperdiam() {
        return fperdiam;
    }

    public Fsectors getSector() {
        return sector;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="rma_addr_odos_akin", referencedColumnName = "id", updatable = false, insertable = false)
    @Fetch(FetchMode.SELECT)
    private Faddress faddress;

    @Column(name="rma_addr_no1_akin")
    private Long addr_no1;

    @Column(name="rma_addr_no2_akin")
    private String addr_no2;

    @Column(name="rma_parathr")
    private String parathr;

    @Column(name="rma_perigr_addr")
    private String perigr_addr;

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

    public String getAddr_odos_akin() {
        return addr_odos_akin;
    }

    public String getYdrometro() {
        return ydrometro;
    }

    public Integer getEmr() {
        return emr;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getParathr() {
        return parathr;
    }

    public Faddress getFaddress() {
        return faddress;
    }

    public Long getAddr_no1() {
        return addr_no1;
    }

    public String getAddr_no2() {
        return addr_no2;
    }

    public String getPerigr_addr() {
        return perigr_addr;
    }

    public Fconsumers() {
    }

}
