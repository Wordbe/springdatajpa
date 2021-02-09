package co.wordbe.redaccount;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class RedAccount {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();








    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @Embedded
    private Address address;

    private String yes;

    @Transient
    private String no;

    public void getStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
