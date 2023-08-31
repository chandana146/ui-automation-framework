package stl.ui.automation.framework.base.ui.accessibility;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import stl.ui.automation.framework.base.ui.UiFactory;


public class AccessibilityTest {

  public static Performable runAccessibilityTest(){
    return Task.where("{0} runs the accessibility test",
        actor  ->  UiFactory.accessHelp.startAccessibilityTest(BrowseTheWeb.as(actor).getDriver())
    );
  }

  public static void getViolationsReport(){
    UiFactory.accessHelp.ensureNoViolationsPresent();
  }



}
