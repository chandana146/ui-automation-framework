package stl.ui.automation.framework.base.ui.utils;

import java.util.HashMap;
import stl.ui.automation.framework.base.ui.UiFactory;
import stl.ui.automation.framework.base.ui.utils.Constants.LoginElementNames;
import stl.ui.automation.framework.base.ui.utils.Constants.TypeOftest;

public class GetTestData {


  public String returnTestData(String typeOfTest, String dataTobeEntered, String elementName){
    TypeOftest tTest = Constants.TypeOftest.valueOf(typeOfTest.toUpperCase());
    switch (tTest){
      case OUTLINE:
      case SCENARIO:
        return dataTobeEntered;
      case EXCEL:
      case CSV:
       return getTestCaseData(dataTobeEntered,elementName);

      case EXCELLOGIN:
      case CSVLOGIN: {
        String loginData = getTestCaseData(dataTobeEntered, LoginElementNames.username.name())+","+
            getTestCaseData(dataTobeEntered, LoginElementNames.password.name())+","+
            getTestCaseData(dataTobeEntered, LoginElementNames.loginbtn.name());
        return loginData;
      }
      default:
        return "ERROR";

    }
  }

  private String getTestCaseData(String data, String name){
    HashMap<String, String> dataM = new HashMap<>();
    String [] testData = UiFactory.customVar.getTestcaseMap(data).split("%")[1]
        .replace("{", "").replace("}", "").split(",");
    System.out.println(testData);
    for (int i=0;i<testData.length;i++) {
      String pair = testData[i].trim();
      String[] keyValue = pair.split("=");
      dataM.put(keyValue[0], keyValue[1]);
    }
    return  dataM.get(name);

  }


  private HashMap<String, String>  getTestCaseHashMap(String data){
    HashMap<String, String> dataM = new HashMap<>();
    String [] testData = UiFactory.customVar.getTestcaseMap(data).split("%")[1]
        .replace("{", "").replace("}", "").split(",");
    for (int i=0;i<testData.length;i++) {
      String pair = testData[i].trim();
      String[] keyValue = pair.split("=");
      dataM.put(keyValue[0], keyValue[1]);
    }
    return  dataM;

  }

}
