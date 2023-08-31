package stl.ui.automation.framework.livereporting;


import io.cucumber.java.Scenario;
import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import stl.ui.automation.framework.base.ui.utils.Constants.TestResult;

public class LiveReporting {

  public static final InfluxDB INFLUXDB = InfluxDBFactory.connect(System.getenv("influx-url"), "root", "root");
  public static final String Database = System.getenv("database");

  static {
    INFLUXDB.setDatabase(Database);
  }

  public static void send(final Point point){
    INFLUXDB.write(point);
  }

 // @After
  public  void sendScenarioStatus(Scenario scenario){
    String scenarioStatus = null;
    if (scenario.isFailed()) {
     scenarioStatus= TestResult.Fail.name();
    }
    else {
      scenarioStatus = TestResult.Pass.name();
    }
    Point point = Point.measurement("ScenarioDetails")
        .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
        .tag("Scenario Name", scenario.getName())
        .tag("SceStatus", scenarioStatus)
        .tag("project", "Sample Project")
        .addField("project", "Sample Project")
        .addField("result", scenarioStatus)
        .addField("ScenarioName", scenario.getName())
        .build();

    send(point);

  }



}
