package pydra.integration.Fkatamet;

import javax.persistence.*;

@Entity
@Table(name="ydr_fkatamet")
public class Fkatamet {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
//    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "code")
    private Long code;

    @Column(name = "name")
    private String name;

    @Column(name = "emailaccount")
    private String emailaccount;


    public Fkatamet() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailaccount() {
        return emailaccount;
    }

    public void setEmailaccount(String emailaccount) {
        this.emailaccount = emailaccount;
    }
}
