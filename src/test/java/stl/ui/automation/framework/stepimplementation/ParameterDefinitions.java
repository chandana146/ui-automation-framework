package stl.ui.automation.framework.stepimplementation;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stl.ui.automation.framework.base.ui.UiFactory;

public class ParameterDefinitions {

  private static final Logger logger = LoggerFactory.getLogger(ParameterDefinitions.class);

  @ParameterType(".*")
  public Actor actor(String actorName) {
    return OnStage.theActorCalled(actorName);
	 // return null;
  }

  @Before
  public void setTheStage() {
    UiFactory.init();
    UiFactory.setVariablesToMap.loadPropertyFile("default");
    UiFactory.setVariablesToMap.readPageLocatorProperties();
    //String switchCase = System.getenv("testType");
    String switchCase="CSV";
    switch(switchCase.toUpperCase()){
      case "OUTLINE":
      case "SCENARIO":
        logger.info("This scenario does not require loading of csv or excel data");
        break;
      case "EXCEL":
        UiFactory.testDataReadExcel.readTestDataExcel();
        break;
      case "CSV":
        UiFactory.testDataReadCsv.readCsv();
        break;
      default:
        logger.info("ERROR in reading");
        break;
    }
    //UiFactory.setVariablesToMap.loadPropertyFile(System.getenv("env"));
   // UiFactory.setVariablesToMap.loadPropertyFile("default");
    //UiFactory.setVariablesToMap.readPageLocatorProperties();
    OnStage.setTheStage(new OnlineCast());
  }
}