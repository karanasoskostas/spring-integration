package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetail;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="androiduploaddetail")
public class AndroidUploadDetail {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "id")
    private Long id;

    @Column(name = "file_id")
    private Long fileid;

    @Column(name = "aa")
    private Long aa;

    @Column(name = "deya_aa")
    private Long deyaaa;

    @Column(name = "maa")
    private Long maa;

    @Column(name = "tomeas")
    private Long tomeas;

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    private Long status;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "ydrometro")
    private String serial_number;

    @Column(name = "prohg")
    private Long prohg;

    @Column(name = "nea")
    private Long nea;

    @Column(name = "metrhseis")
    private String metrhseis;

    @Column(name = "com")
    private String com;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "owner")
    private String owner;

    @Column(name = "ektyp_code")
    private String ektypcode;

    @Column(name = "dblat")
    private String dblat;

    @Column(name = "dblng")
    private String dblng;

    @Column(name = "entrylat")
    private String entrylat;

    @Column(name = "entrylng")
    private String entrylng;

    @Column(name = "modified_date")
    private Date modifieddate;

    @Column(name = "blabh1")
    private Long blabh1;

    @Column(name = "blabh2")
    private Long blabh2;

    @Column(name = "blabh3")
    private Long blabh3;

    @Column(name = "neo_ydrometro")
    private String neoydrometro;

    @Column(name = "kat_com")
    private String katcom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileid() {
        return fileid;
    }

    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }

    public Long getAa() {
        return aa;
    }

    public void setAa(Long aa) {
        this.aa = aa;
    }

    public Long getDeyaaa() {
        return deyaaa;
    }

    public void setDeyaaa(Long deyaaa) {
        this.deyaaa = deyaaa;
    }

    public Long getMaa() {
        return maa;
    }

    public void setMaa(Long maa) {
        this.maa = maa;
    }

    public Long getTomeas() {
        return tomeas;
    }

    public void setTomeas(Long tomeas) {
        this.tomeas = tomeas;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Long getProhg() {
        return prohg;
    }

    public void setProhg(Long prohg) {
        this.prohg = prohg;
    }

    public Long getNea() {
        return nea;
    }

    public void setNea(Long nea) {
        this.nea = nea;
    }

    public String getMetrhseis() {
        return metrhseis;
    }

    public void setMetrhseis(String metrhseis) {
        this.metrhseis = metrhseis;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEktypcode() {
        return ektypcode;
    }

    public void setEktypcode(String ektypcode) {
        this.ektypcode = ektypcode;
    }

    public String getDblat() {
        return dblat;
    }

    public void setDblat(String dblat) {
        this.dblat = dblat;
    }

    public String getDblng() {
        return dblng;
    }

    public void setDblng(String dblng) {
        this.dblng = dblng;
    }

    public String getEntrylat() {
        return entrylat;
    }

    public void setEntrylat(String entrylat) {
        this.entrylat = entrylat;
    }

    public String getEntrylng() {
        return entrylng;
    }

    public void setEntrylng(String entrylng) {
        this.entrylng = entrylng;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public Long getBlabh1() {
        return blabh1;
    }

    public void setBlabh1(Long blabh1) {
        this.blabh1 = blabh1;
    }

    public Long getBlabh2() {
        return blabh2;
    }

    public void setBlabh2(Long blabh2) {
        this.blabh2 = blabh2;
    }

    public Long getBlabh3() {
        return blabh3;
    }

    public void setBlabh3(Long blabh3) {
        this.blabh3 = blabh3;
    }

    public String getNeoydrometro() {
        return neoydrometro;
    }

    public void setNeoydrometro(String neoydrometro) {
        this.neoydrometro = neoydrometro;
    }

    public String getKatcom() {
        return katcom;
    }

    public void setKatcom(String katcom) {
        this.katcom = katcom;
    }
}
