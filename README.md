# Custom metric gatling

Рабочая основа, далее будут добавляться новые конструкторы поинтов.

## Начало работы.

В файле inject Gatling-а настраиваем подключение:
```
public class Stab extends Simulation {
    public static ConfigInfluxConnect conf = new ConfigInfluxConnect("url_influx", "username", "password"); // Конфиг подключения 
    public static ConfigInfluxPackeg conf_pack = new ConfigInfluxPackeg(); // Конфиг пакетной записи

    public static InfluxDB influxdb = InfluxFactory.connect_influx(conf, conf_pack); // Подключение
    public static BatchPoints batchPoints = InfluxFactory.batch_points("measurement"); // Задаем БД по умолчанию

    {
        setUp(
                scn_post.injectOpen(
                        constantUsersPerSec(count_open_user).during(Duration.ofMinutes(time_test_minutes))
                ).protocols(httpProtocol)
        );
    }

}
```

## В сессии сценария зодаем поинт и делаем отправку.
```
    ...
    ,exec(
        session -> {
            String name = session.getString("nameU");
            Point point = MetricCounter.counter("measurement", "name_tag", "value_tag", "name", "value");
            InfluxFactory.sending_data(influxdb, batchPoints, point);
            return session;
        }
    )
