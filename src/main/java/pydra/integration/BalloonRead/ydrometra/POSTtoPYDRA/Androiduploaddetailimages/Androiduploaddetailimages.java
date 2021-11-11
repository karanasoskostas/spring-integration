package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetailimages;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="androiduploaddetailimages")
@Getter
public class Androiduploaddetailimages {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "id")
    private Long id;

    @Column(name = "detail_id")
    private Long detailid;

    @Column(name = "imageurl")
    private String imageurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
