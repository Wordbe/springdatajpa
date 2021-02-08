package co.wordbe.post;

import org.springframework.context.event.EventListener;

public class PostListener {

    @EventListener
    public void onApplicationEvent(PostPublishEvent postPublishEvent) {
        System.out.println(postPublishEvent.getPost().getTitle() + " published.");
    }
}
