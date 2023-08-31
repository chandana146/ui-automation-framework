package stl.ui.automation.framework.base.ui.utils;
import  org.openqa.selenium.Keys;

public class Constants {
  public enum pageObjects {
    PageObjects;

  }
  public enum GeneralElements {
    submit("submit"),
    uploadFileLocation("uploadFile"),
    locatorsDirectory("/src/test/resources/locators");

    private final String value;

    private GeneralElements(String value) {
      this.value = value;

    }

    public String getValue() {
      return value;
    }
  }

  public enum TypeOftest {
    OUTLINE,
    SCENARIO,
    EXCEL,
    CSV,
    EXCELLOGIN,
    CSVLOGIN;

  }

  public enum LoginElementNames {
     username,
    password,
    loginbtn;
  }

  public enum TypesOfKeys{
   ENTER(Keys.ENTER),
   DOWN(Keys.DOWN),
   UP(Keys.UP);

    private final Keys type;

    private TypesOfKeys(Keys type) {
      this.type = type;

    }

    public Keys getType() {
      return type;
    }
  }

  public enum TestResult{
    Pass,
    Fail,
    Skipped;
  }

  }