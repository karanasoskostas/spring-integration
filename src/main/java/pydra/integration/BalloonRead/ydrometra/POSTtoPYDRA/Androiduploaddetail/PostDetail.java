package pydra.integration.BalloonRead.ydrometra.POSTtoPYDRA.Androiduploaddetail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PostDetail {

    @Id
    private String serial_number;
    private Date date;
    private String value;

}
