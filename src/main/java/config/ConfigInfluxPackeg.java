package config;

import java.util.concurrent.TimeUnit;

public class ConfigInfluxPackeg {

    // default values here are consistent with Telegraf //
    public int DEFAULT_BATCH_ACTIONS_LIMIT;
    public int DEFAULT_BATCH_INTERVAL_DURATION;
    public int DEFAULT_JITTER_INTERVAL_DURATION;
    public int DEFAULT_BUFFER_LIMIT;
    public TimeUnit DEFAULT_PRECISION;
    public boolean DEFAULT_DROP_ACTIONS_ON_QUEUE_EXHAUSTION;


    public ConfigInfluxPackeg(){
        this.DEFAULT_BATCH_ACTIONS_LIMIT = 1000;
        this.DEFAULT_BATCH_INTERVAL_DURATION = 1000;
        this.DEFAULT_JITTER_INTERVAL_DURATION = 0;
        this.DEFAULT_BUFFER_LIMIT = 10000;
        this.DEFAULT_PRECISION = TimeUnit.NANOSECONDS;
        this.DEFAULT_DROP_ACTIONS_ON_QUEUE_EXHAUSTION = false;
    }
    public ConfigInfluxPackeg(int default_batch_actions_limit, int default_batch_interval_duration,
                              int default_jitter_interval_duration, int default_buffer_limit,
                              TimeUnit default_precision, boolean default_drop_actions_on_queue_exhaustion){

        this.DEFAULT_BATCH_ACTIONS_LIMIT = default_batch_actions_limit;
        this.DEFAULT_BATCH_INTERVAL_DURATION = default_batch_interval_duration;
        this.DEFAULT_JITTER_INTERVAL_DURATION = default_jitter_interval_duration;
        this.DEFAULT_BUFFER_LIMIT = default_buffer_limit;
        this.DEFAULT_PRECISION = default_precision;
        this.DEFAULT_DROP_ACTIONS_ON_QUEUE_EXHAUSTION = default_drop_actions_on_queue_exhaustion;

    }
}
