package stl.ui.automation.framework.base.ui.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
  public static Performable theApplicationHomePage() {
    return Task.where("{0} opens the Application home page",
        Open.browserOn().the(ApplicationHomePage.class));
  }
}
