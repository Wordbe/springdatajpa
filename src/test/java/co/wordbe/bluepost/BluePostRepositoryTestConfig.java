package co.wordbe.bluepost;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BluePostRepositoryTestConfig {
    @Bean
    public ApplicationListener<BluePostPublishEvent> postListener() {
        return bluePostPublishEvent ->
                System.out.println(bluePostPublishEvent.getBluePost().getTitle() + " published.");
    }
}
