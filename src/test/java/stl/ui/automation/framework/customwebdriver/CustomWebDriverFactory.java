package stl.ui.automation.framework.customwebdriver;

import java.net.MalformedURLException;
import java.net.URL;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CustomWebDriverFactory implements DriverSource {

  @Override
  public WebDriver newDriver() {
    try {
      ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", System.getenv("browser"));
      String url = System.getenv("hub-url");
      return new RemoteWebDriver(
          new URL(url),
          capabilities);
    }
    catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean takesScreenshots() {
    return true;
  }
}