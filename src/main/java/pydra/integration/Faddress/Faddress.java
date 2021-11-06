package pydra.integration.Faddress;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ydr_faddress")
public class Faddress {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "id")
    private Long id;

    @Column(name = "rad_address")
    private String address;

    @Column(name = "rad_polh")
    private String polh;

    @Column(name = "rad_tk")
    private String tk;

    @Column(name = "rad_perioxh")
    private String perioxh;

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPolh() {
        return polh;
    }

    public String getTk() {
        return tk;
    }

    public String getPerioxh() {
        return perioxh;
    }
}
