package pydra.integration.test;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;


public class test {

    @Column(name = "id")
    private Long id;

    @Column(name = "eidos")
    private Long eidos;

    @Column(name = "descr")
    private String descr;

    public test(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEidos() {
        return eidos;
    }

    public void setEidos(Long eidos) {
        this.eidos = eidos;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
