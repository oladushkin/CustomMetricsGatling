package conect_close;

import config.ConfigInfluxConnect;
import config.ConfigInfluxPackeg;
import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;

public class InfluxFactory {

    public static InfluxDB connect_influx(ConfigInfluxConnect conf_connect, ConfigInfluxPackeg conf_packeg) {
        InfluxDB influxDB = InfluxDBFactory.connect(conf_connect.serverURL, conf_connect.username, conf_connect.password);
        System.out.println("Connect DB");
        batch_recording_setup(influxDB, conf_packeg);
        System.out.println("Пакетная запись настроена");
        return influxDB;
    }

    public static InfluxDB batch_recording_setup(InfluxDB influxDB, ConfigInfluxPackeg conf){
        influxDB.enableBatch(
                BatchOptions.DEFAULTS.actions(conf.DEFAULT_BATCH_ACTIONS_LIMIT)
                        .flushDuration(conf.DEFAULT_BATCH_INTERVAL_DURATION)
                        .jitterDuration(conf.DEFAULT_JITTER_INTERVAL_DURATION)
                        .bufferLimit(conf.DEFAULT_BUFFER_LIMIT)
                        .precision(conf.DEFAULT_PRECISION)
                        .dropActionsOnQueueExhaustion(conf.DEFAULT_DROP_ACTIONS_ON_QUEUE_EXHAUSTION)
        );
        return influxDB;
    }

    public static BatchPoints batch_points(String databaseName){
        BatchPoints batchPoints = BatchPoints.database(databaseName).build();
        return batchPoints;
    }

    public static void sending_data(InfluxDB influxDB, BatchPoints batchPoints, Point point){
        batchPoints.point(point);
        influxDB.write(batchPoints);
    }

    public static void close_influx(InfluxDB influxDB) {
        influxDB.close();
        System.out.println("Close");
    }
}
