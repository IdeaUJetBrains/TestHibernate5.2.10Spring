package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author Adrian Lapierre {@literal <alapierre@soft-project.pl>}
 */
@Entity
//@Table(name = "SAMPLE_ENTITY", schema = "PUBLIC")
@Getter
@Setter
public class SampleEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

//    @Column(name = "CREATION_DATE")
    private String creationDate;


}
