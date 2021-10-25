package pydra.integration.AndroidMaster;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Androidmaster")
public class Androidmaster {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "id")
    private Long id;


    @Column(name="sort_descr")
    private String sort_descr;

    @Column(name="descr")
    private String descr;

    @Column(name="trim")
    private Long trim;

    @Column(name="etos")
    private Long etos;

    @Column(name="tomeas")
    private Long tomeas;

    @Column(name="tomeas_descr")
    private String tomeas_descr;

    @Column(name="from_code")
    private String from_code;

    @Column(name="to_code")
    private String to_code;

    @Column(name="create_date")
    private Date create_date;

    @Column(name="usr")
    private String  usr;

    @Column(name="com")
    private String com;

    @Column(name="deya_aa")
    private Long deya_aa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSort_descr() {
        return sort_descr;
    }

    public void setSort_descr(String sort_descr) {
        this.sort_descr = sort_descr;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Long getTrim() {
        return trim;
    }

    public void setTrim(Long trim) {
        this.trim = trim;
    }

    public Long getEtos() {
        return etos;
    }

    public void setEtos(Long etos) {
        this.etos = etos;
    }

    public Long getTomeas() {
        return tomeas;
    }

    public void setTomeas(Long tomeas) {
        this.tomeas = tomeas;
    }

    public String getTomeas_descr() {
        return tomeas_descr;
    }

    public void setTomeas_descr(String tomeas_descr) {
        this.tomeas_descr = tomeas_descr;
    }

    public String getFrom_code() {
        return from_code;
    }

    public void setFrom_code(String from_code) {
        this.from_code = from_code;
    }

    public String getTo_code() {
        return to_code;
    }

    public void setTo_code(String to_code) {
        this.to_code = to_code;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public Long getDeya_aa() {
        return deya_aa;
    }

    public void setDeya_aa(Long deya_aa) {
        this.deya_aa = deya_aa;
    }

    @Override
    public String toString() {
        return "Androidmaster{" +
                "id=" + id +
                ", sort_descr='" + sort_descr + '\'' +
                ", descr='" + descr + '\'' +
                ", trim=" + trim +
                ", etos=" + etos +
                ", tomeas=" + tomeas +
                ", tomeas_descr='" + tomeas_descr + '\'' +
                ", from_code='" + from_code + '\'' +
                ", to_code='" + to_code + '\'' +
                ", create_date=" + create_date +
                ", usr='" + usr + '\'' +
                ", com=" + com +
                ", deya_aa=" + deya_aa +
                '}';
    }
}
