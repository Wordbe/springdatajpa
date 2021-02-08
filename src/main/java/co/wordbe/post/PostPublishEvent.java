package co.wordbe.post;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PostPublishEvent extends ApplicationEvent {

    private final Post post;

    public PostPublishEvent(Object source) {
        super(source);
        this.post = (Post) source;
    }
}
