package pydra.integration.Fpersons;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name="ydr_fpersons")
public class Fpersons {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "RPE_LASTNAME")
    private String lastname;

    @JsonIgnore
    @Column(name = "RPE_FIRSTNAME")
    private String firstname;

    @JsonIgnore
    @Column(name = "RPE_FATHERNAME")
    private String fathername;

    @Transient
    private String name;

    @Column(name = "RPE_afm")
    private String afm;

    @Column(name = "RPE_adt")
    private String adt;



    public String getName() {
        String fullName="";
        if (this.getLastname() != null) {
            fullName = this.getLastname();
        }
        if (this.getFirstname() != null) {
            fullName = fullName + " "+ this.getLastname();
        }

        return this.getLastname();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getAdt() {
        return adt;
    }

    public void setAdt(String adt) {
        this.adt = adt;
    }

    public Fpersons() {
    }


}
