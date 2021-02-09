package co.wordbe.bluepost;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
public class BluePost extends AbstractAggregateRoot<BluePost> {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public BluePost publish() {
        this.registerEvent(new BluePostPublishEvent(this));
        return this;
    };
}
