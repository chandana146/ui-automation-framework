package stl.ui.automation.framework.base.ui;

import stl.ui.automation.framework.base.ui.accessibility.AccessibilityHelpers;
import stl.ui.automation.framework.base.ui.testdata.TestDataReadCsv;
import stl.ui.automation.framework.base.ui.testdata.TestDataReadExcel;
import stl.ui.automation.framework.base.ui.utils.GetLocators;
import stl.ui.automation.framework.base.ui.utils.GetTestData;
import stl.ui.automation.framework.base.ui.utils.SetVariablesToMap;
import stl.ui.automation.framework.base.ui.utils.VariableDefinitions;

public class UiFactory {

  public static VariableDefinitions customVar;

  public static SetVariablesToMap setVariablesToMap;

  public static GetLocators getLocators;

  public static GetTestData getTestData;

  public static AccessibilityHelpers accessHelp;

  public static TestDataReadExcel testDataReadExcel;
  public static TestDataReadCsv testDataReadCsv;


  public static void init(){
    customVar = new VariableDefinitions();
    setVariablesToMap = new SetVariablesToMap();
    getLocators = new GetLocators();
    getTestData = new GetTestData();
    accessHelp = new AccessibilityHelpers();
    testDataReadExcel = new TestDataReadExcel();
    testDataReadCsv = new TestDataReadCsv();

  }

}
