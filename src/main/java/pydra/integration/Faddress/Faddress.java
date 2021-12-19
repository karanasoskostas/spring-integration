package pydra.integration.Faddress;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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


}
