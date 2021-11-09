package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="androiddetail")
public class AndroidDetailPost {
    @Id
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "file_id")
    private Long file_id;

    @Column(name = "ydrometro")
    private String serial_number;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="file_id", referencedColumnName = "id", updatable = false, insertable = false)
    private AndroidMasterPost masterpost;

    public Long getId() {
        return id;
    }

    public String getSerial_number() {
        return serial_number;
    }
}
