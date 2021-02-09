package co.wordbe.bluepost;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class BluePostPublishEvent extends ApplicationEvent {

    private final BluePost bluePost;

    public BluePostPublishEvent(Object source) {
        super(source);
        this.bluePost = (BluePost) source;
    }
}
