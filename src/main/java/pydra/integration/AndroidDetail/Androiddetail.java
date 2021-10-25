package pydra.integration.AndroidDetail;

import javax.persistence.*;

@Entity
@Table(name="Androiddetail")
public class Androiddetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "id")
    private Long id;

    @Column(name = "file_id")
    private Long fileid;

    @Column(name = "aa")
    private Long aa;

    @Column(name = "deya_aa")
    private Long deya_aa;

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
    private String ydrometro;

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
    private String ektyp_code;

    @Column(name = "freatio")
    private String freatio;

    @Column(name = "addr_no")
    private Long addr_no;

    @Column(name = "orofos")
    private String orofos;

    @Column(name = "timologio")
    private String timologio;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFile_id() {
        return fileid;
    }

    public void setFile_id(Long file_id) {
        this.fileid = file_id;
    }

    public Long getAa() {
        return aa;
    }

    public void setAa(Long aa) {
        this.aa = aa;
    }

    public Long getDeya_aa() {
        return deya_aa;
    }

    public void setDeya_aa(Long deya_aa) {
        this.deya_aa = deya_aa;
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

    public String getYdrometro() {
        return ydrometro;
    }

    public void setYdrometro(String ydrometro) {
        this.ydrometro = ydrometro;
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

    public String getEktyp_code() {
        return ektyp_code;
    }

    public void setEktyp_code(String ektyp_code) {
        this.ektyp_code = ektyp_code;
    }

    public String getFreatio() {
        return freatio;
    }

    public void setFreatio(String freatio) {
        this.freatio = freatio;
    }

    public Long getAddr_no() {
        return addr_no;
    }

    public void setAddr_no(Long addr_no) {
        this.addr_no = addr_no;
    }

    public String getOrofos() {
        return orofos;
    }

    public void setOrofos(String orofos) {
        this.orofos = orofos;
    }

    public String getTimologio() {
        return timologio;
    }

    public void setTimologio(String timologio) {
        this.timologio = timologio;
    }

    @Override
    public String toString() {
        return "Androiddetail{" +
                "id=" + id +
                ", file_id=" + fileid +
                ", aa=" + aa +
                ", deya_aa=" + deya_aa +
                ", maa=" + maa +
                ", tomeas=" + tomeas +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", ydrometro='" + ydrometro + '\'' +
                ", prohg=" + prohg +
                ", nea=" + nea +
                ", metrhseis='" + metrhseis + '\'' +
                ", com='" + com + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", owner='" + owner + '\'' +
                ", ektyp_code='" + ektyp_code + '\'' +
                ", freatio='" + freatio + '\'' +
                ", addr_no=" + addr_no +
                ", orofos='" + orofos + '\'' +
                ", timologio=" + timologio +
                '}';
    }
}
