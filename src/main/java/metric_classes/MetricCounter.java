package metric_classes;


import org.influxdb.dto.Point;
import java.util.concurrent.TimeUnit;


public class MetricCounter {

    public static Point counter(String measurement, String name_tag, String value_tag, String name, String value){
        return Point.measurement(measurement)
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag(name_tag, value_tag)
                .addField(name, value)
                .build();
    }
}
