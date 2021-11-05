package pydra.integration.Snd_genpar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="snd_genpar")
public class Sndgenpar {

    @Id
    @Column(name = "id")
    private Long id;


    @Column(name = "diadromh_format")
    private String diadromhformat;

    public String getDiadromhformat() {
        return diadromhformat;
    }
}
