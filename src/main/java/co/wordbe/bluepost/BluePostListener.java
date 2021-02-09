package co.wordbe.bluepost;

import org.springframework.context.event.EventListener;

public class BluePostListener {

    @EventListener
    public void onApplicationEvent(BluePostPublishEvent bluePostPublishEvent) {
        System.out.println(bluePostPublishEvent.getBluePost().getTitle() + " published.");
    }
}
