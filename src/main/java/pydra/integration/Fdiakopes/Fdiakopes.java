package pydra.integration.Fdiakopes;

import pydra.integration.Fperdiak.Fperdiak;

import javax.persistence.*;

@Entity
@Table(name="Ydr_Fdiakopes")
public class Fdiakopes {


    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "id")
    private Long id;

    @Column(name = "rdiak_maa")
    private Long maa;

    @Column(name = "rdiak_aa")
    private Long aa;

    @Column(name = "diakopes_status")
    private Long status;

    @Column(name = "rdiak_eidos", updatable = false, insertable = false)
    private Long diakeidos;

    @ManyToOne
    @JoinColumn(name="rdiak_eidos", referencedColumnName = "rpdiak_code")
    private Fperdiak fperdiak;
////    @Transient
//    private String fperdiakdescr;

    public Fdiakopes(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaa() {
        return maa;
    }

    public void setMaa(Long maa) {
        this.maa = maa;
    }

    public Long getAa() {
        return aa;
    }

    public void setAa(Long aa) {
        this.aa = aa;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getDiakeidos() {
        return diakeidos;
    }

    public void setDiakeidos(Long diakeidos) {
        this.diakeidos = diakeidos;
    }

    public Fperdiak getFperdiak() {
        return fperdiak;
    }

    public void setFperdiak(Fperdiak fperdiak) {
        this.fperdiak = fperdiak;
    }

    @Override
    public String toString() {
        return "Fdiakopes{" +
                "id=" + id +
                ", maa=" + maa +
                ", aa=" + aa +
                ", status=" + status +
                '}';
    }
}
