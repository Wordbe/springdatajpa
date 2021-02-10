package co.wordbe.redpost;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class RedPost {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "redPost", cascade = CascadeType.ALL)
    private Set<RedComment> redComments = new HashSet<>();

    public void addComent(RedComment redComment) {
        this.getRedComments().add(redComment);
        redComment.setRedPost(this);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                '}';
    }
}
