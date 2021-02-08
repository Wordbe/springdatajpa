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
    private Set<Comment> comments = new HashSet<>();

    public void addComent(Comment comment) {
        this.getComments().add(comment);
        comment.setRedPost(this);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                '}';
    }
}
