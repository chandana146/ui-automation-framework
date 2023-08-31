package stl.ui.automation.framework.base.ui.utils;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import stl.ui.automation.framework.base.ui.UiFactory;
import stl.ui.automation.framework.base.ui.customexception.CustomException;
import stl.ui.automation.framework.base.ui.utils.Constants.GeneralElements;
import java.io.FileInputStream;
import java.io.InputStream;


public class SetVariablesToMap {

  public void loadPropertyFile(String env) {
    ResourceBundle propertyFileData = ResourceBundle.getBundle(
        "variables." + env + ".inputVariables");
    Enumeration<String> keys = propertyFileData.getKeys();
    System.out.println("line 27");
    while (keys.hasMoreElements()) {
      String key = keys.nextElement();
      System.out.println(key);
      setVariableToMap(key, propertyFileData.getString(key), "variable");
    }
  }

  private void setVariableToMap(String key, String value, String type) {
    try {
    	System.out.println("setVariableMap"+ "Key"+ key +"value"+ value);
      switch (type){
        case "variable":
          UiFactory.customVar.setVariableMapMap(key, value);
          break;
        case "locators":
          UiFactory.customVar.setLocatorMapMap(key, value);
          break;
      }

    } catch (Exception e) {
      new CustomException("Issue in setting environment variables", false);
    }
  }

  public void readPageLocatorProperties() {
    try {
      List<Path> pathList = new ArrayList<>();
      String directory =
          System.getProperty("user.dir") + GeneralElements.locatorsDirectory.getValue();
      try (Stream<Path> stream = Files.walk(Paths.get(directory))) {
        pathList = stream.map(Path::normalize)
            .filter(Files::isRegularFile)
            .collect(Collectors.toList());

        pathList.forEach(
            (file) -> {
              try(InputStream inputStream = new FileInputStream(file.toFile())){
                Properties locatorProp = new Properties();
                locatorProp.load(inputStream);
                Enumeration locEnumuration = locatorProp.propertyNames();
                while(locEnumuration.hasMoreElements()){
                  String key = (String) locEnumuration.nextElement();
                  setVariableToMap(key, locatorProp.getProperty(key), "locators");
                  System.out.println("locprop"+ locatorProp.getProperty(key));
                  String [] keyArray = key.split("-");
                  System.out.println("key in setVar"+ key);
                  setVariableToMap(keyArray[0], keyArray[1], "variable");
                }
                locatorProp.clear();
              }catch(Exception e){
                new CustomException("Issue while reading page locators prop files", false);
              }
            }
        );

      } catch (Exception e) {
        new CustomException("Issue while reading page locators directory for listing file",
            false);
      }
    } catch (Exception e) {
      new CustomException("Issue while reading page locators directory for listing files and reading it",
          false);
    }

  }
}





