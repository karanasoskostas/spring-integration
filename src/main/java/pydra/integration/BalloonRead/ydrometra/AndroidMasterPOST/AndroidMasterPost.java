package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="androidmaster")
public class AndroidMasterPost  {
    @Id
    @Column(name="id")
    private Long code;

    @Column(name="sort_descr")
    private String route_name;

    @Column(name="descr")
    private String description;

    @Column(name="create_date")
    private Date start_date;

    @Column(name="create_date", updatable = false,insertable = false)
    private Date end_date;

    @JsonIgnore
    @Column(name="trim")
    private Long trim;

    @JsonIgnore
    @Column(name="etos")
    private Long etos;

    @Transient
    private String period;


    @OneToMany(mappedBy = "masterpost", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private Set<AndroidDetailPost> meters;

    public AndroidMasterPost() {
    }

    public Long getCode() {
        return code;
    }

    public String getRoute_name() {
        return route_name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public Long getTrim() {
        return trim;
    }

    public Long getEtos() {
        return etos;
    }

    public String getPeriod() {
        return this.trim.toString()+"/"+this.etos.toString();
    }

    public Set<AndroidDetailPost> getMeters() {
        return meters;
    }

    @Override
    public String toString() {
        return "AndroidMasterPost{" +
                "code=" + code +
                ", route_name='" + route_name + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", trim=" + trim +
                ", etos=" + etos +
                ", period='" + period + '\'' +
                ", meters=" + meters +
                '}';
    }
}
