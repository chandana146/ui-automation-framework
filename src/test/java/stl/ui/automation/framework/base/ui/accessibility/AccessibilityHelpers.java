package stl.ui.automation.framework.base.ui.accessibility;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import org.openqa.selenium.WebDriver;
import stl.ui.automation.framework.base.ui.UiFactory;
import static org.assertj.core.api.Assertions.assertThat;

public class AccessibilityHelpers {

  public void startAccessibilityTest(WebDriver driver) {

    AxeBuilder builder = new AxeBuilder();
    Results results = builder.analyze(driver);
    UiFactory.customVar.setViolations(results.getViolations());
    UiFactory.customVar.setResults(results);
    System.out.println();
    System.out.println(results.getViolations().size());

  }

  public void ensureNoViolationsPresent(){
    if (UiFactory.customVar.getViolations().size() == 0)
    {
      assertThat(UiFactory.customVar.getViolations().size()).isEqualTo(0);
    }
    else
    {
      AxeReporter.writeResultsToJsonFile(UiFactory.customVar.returnReportFilePath(),
          UiFactory.customVar.getResults());
    }
  }
  }




