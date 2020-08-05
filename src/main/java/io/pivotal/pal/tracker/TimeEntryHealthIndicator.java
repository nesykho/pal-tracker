package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {
    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryHealthIndicator(TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository= timeEntryRepository;
    }

    @Override
    public Health health() {
        Health.Builder builder= new Health.Builder();
        if(timeEntryRepository.list().size()<5){
            builder.up();
        }
        else{
            builder.down();
        }
        return builder.build();
    }
}
