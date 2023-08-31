package stl.ui.automation.framework.base.ui.utils;

import stl.ui.automation.framework.base.ui.UiFactory;

public class GetLocators {

  public String returnLocator(String fieldName){
	  System.out.println("fieldname - -"+fieldName);
    String locatorPage = UiFactory.customVar.getVariableMapMap(fieldName);
    String actualLocator = UiFactory.customVar.getLocatorMapMap(fieldName+"-"+locatorPage);
    return actualLocator;
  }

  public String returnLoginCredsLocator(String fieldName){
	  System.out.println("fieldname - -"+fieldName);
    String locatorPage = UiFactory.customVar.getVariableMapMap(fieldName);
    System.out.println("line17 "+locatorPage);
    String actualLocator = UiFactory.customVar.getLocatorMapMap(fieldName+"-"+locatorPage);
    System.out.println("line19 "+actualLocator);
    return actualLocator;
  }

}
