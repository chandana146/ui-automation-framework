package stl.ui.automation.framework.base.ui.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DeselectFromOptions;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.RightClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stl.ui.automation.framework.base.ui.UiFactory;
import stl.ui.automation.framework.base.ui.customexception.CustomException;
import stl.ui.automation.framework.base.ui.utils.Constants.LoginElementNames;
import stl.ui.automation.framework.base.ui.utils.Constants.TypeOftest;
import stl.ui.automation.framework.base.ui.utils.Constants.TypesOfKeys;

public class Tasks {

  public static Performable enterAValueAndClick(String enterData, String enterFieldName, String testType) {
    String locator = UiFactory.getLocators.returnLocator(enterFieldName);
    String data = UiFactory.getTestData.returnTestData(testType,enterData,enterFieldName);
    WaitUntil.the(locator, isVisible()).forNoMoreThan(20).seconds();
    return Enter.theValue(data)
            .into(locator)
            .thenHit(Keys.ENTER);
  }

  public static Performable enterAValue(String enterData, String enterFieldName, String testType) {
    String locator = UiFactory.getLocators.returnLocator(enterFieldName);
    String data = UiFactory.getTestData.returnTestData(testType,enterData,enterFieldName);
    WaitUntil.the(locator, isVisible()).forNoMoreThan(20).seconds();
    return Enter.theValue(data)
        .into(locator);
  }

  public static Performable enterAValueBySendKeys(String enterData, String enterFieldName, String testType) {
    String locator = UiFactory.getLocators.returnLocator(enterFieldName);
    String data = UiFactory.getTestData.returnTestData(testType,enterData,enterFieldName);
    WaitUntil.the(locator, isVisible()).forNoMoreThan(20).seconds();
    return SendKeys.of(data)
        .into(locator)
        .thenHit(Keys.ENTER);
  }
  public static Performable clickALink(String AccountName,String Accountname,String testType) {
	  String locator = UiFactory.getLocators.returnLocator(Accountname);
	  String AccountNameXpath="//span[@class='slds-grid slds-grid--align-spread']/a[@title='"+AccountName+"']";
	  System.out.println("line 68 " + AccountNameXpath);
	  System.out.println("line 69 "+AccountName);
	    return Click.on(locator).then(Click.on(Target.the("Accname").locatedBy(AccountNameXpath)));  
 }
  public static Performable clickAction(String buttonName) {
    String locator = UiFactory.getLocators.returnLocator(buttonName);
    WaitUntil.the(locator, isVisible()).forNoMoreThan(20).seconds();
    return Click.on(locator);
  }

  public static Performable javascriptClickAction(String buttonName) {
    String locator = UiFactory.getLocators.returnLocator(buttonName);
    WaitUntil.the(locator, isVisible()).forNoMoreThan(20).seconds();
    return JavaScriptClick.on(locator);
  }

  public static void jsClickOnElement(String buttonName, Actor actor) {
    String locator = UiFactory.getLocators.returnLocator(buttonName);
    WaitUntil.the(locator, isVisible()).forNoMoreThan(20).seconds();
    BrowseTheWeb.as(actor).evaluateJavascript("",locator);
  }

  public static Performable rightClick(String buttonName) {
    String locator = UiFactory.getLocators.returnLocator(buttonName);
    WaitUntil.the(locator, isVisible()).forNoMoreThan(20).seconds();
    return RightClick.on(locator);
  }


  public static void hitEnterKey(String buttonName) {
    String locator = UiFactory.getLocators.returnLocator(buttonName);
    WaitUntil.the(locator, isVisible()).forNoMoreThan(20).seconds();
    Hit.the(TypesOfKeys.ENTER.getType());
  }

  public static void clearElement(String buttonName) {
    String locator = UiFactory.getLocators.returnLocator(buttonName);
    WaitUntil.the(locator, isVisible()).forNoMoreThan(20).seconds();
    Clear.field(locator);
  }


  public static Performable scrollDown(Actor actor,String linkName) {
    String locator = UiFactory.getLocators.returnLocator(linkName);
    BrowseTheWeb.as(actor).evaluateJavascript("javascript:window.scrollBy(200,400)", "");
    return Scroll.to(locator);
  }

  public static void waitForInvisibilityOfElement(){
    String invEle = UiFactory.customVar.getVariableMapMap("invisibleElement");
    String locator = UiFactory.getLocators.returnLocator(invEle);
    WaitUntil.the(locator, isNotVisible()).forNoMoreThan(20).seconds();

  }

  public static Performable loginIntoApplication(String testType,String username, String password,String loginButton,String loginDetails, String data){

    String [] loginCreds = new String[10];
    if (testType.equalsIgnoreCase(TypeOftest.OUTLINE.name()) ||
        testType.equalsIgnoreCase(TypeOftest.SCENARIO.name())){
      loginCreds = loginDetails.split(",");
    }
    else{
//      loginCreds = UiFactory.getTestData
//          .returnTestData(System.getenv("CSV")+
//              "Login","username", data).split(",");
    	loginCreds=UiFactory.getTestData.returnTestData("CSVlogin",data,"username").split(",");
    }

    String usernameLocator = UiFactory.getLocators
        .returnLoginCredsLocator(LoginElementNames.username.name());
    System.out.println("Line 128 "+ usernameLocator);
    String passwordLocator = UiFactory.getLocators
        .returnLoginCredsLocator(LoginElementNames.password.name());
    System.out.println("Line 130 "+ passwordLocator);
    String loginBtnLocator = UiFactory.getLocators
        .returnLoginCredsLocator(LoginElementNames.loginbtn.name());
    System.out.println("Line 134 "+ loginBtnLocator);
    return   Enter.theValue(loginCreds[0])
        .into(usernameLocator)
        .then(Enter.theValue(loginCreds[1])
            .into(passwordLocator)
            .then(Click.on(loginBtnLocator))
        );
  }

  public static Performable switchToActiveElement(){
    return Switch.toActiveElement();
  }


  public static Performable clickCheckBox(String checkBox){
    String locator = UiFactory.getLocators.returnLocator(checkBox);
    return CheckCheckbox.of(locator);
  }



  public static void acceptAlert(Actor actor){
    BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
  }

  public static void dismissAlert(Actor actor){
    BrowseTheWeb.as(actor).getDriver().switchTo().alert().dismiss();
  }


  public static void explicitWait(){
    try{
      TimeUnit.SECONDS.sleep(7);
    } catch(Exception e){
      new CustomException("issue while applying Delay", false);
    }
  }

  public static Performable selectFromOptions(String optionsLocation, String optionsText, String testType){
    String locator = UiFactory.getLocators.returnLocator(optionsLocation);
    String data = UiFactory.getTestData.returnTestData(testType,optionsText,optionsLocation);
    return SelectFromOptions.byVisibleText(data).from(locator);
  }

  public static Performable deselectFromOptions(String optionsLocation, String optionsText, String testType){
    String locator = UiFactory.getLocators.returnLocator(optionsLocation);
    String data = UiFactory.getTestData.returnTestData(testType,optionsText,optionsLocation);
    return DeselectFromOptions.byVisibleText(optionsText).from(locator);
  }

  public static Performable moveMouseToLocation(String mouseMoveLoc){
    String locator = UiFactory.getLocators.returnLocator(mouseMoveLoc);
    return MoveMouse.to(locator);
  }
  public static Performable selectsDropDown(String dropdown, String dropDownValue,String type){
	  String locator = UiFactory.getLocators.returnLocator(dropdown);
	  if(type=="Account") {
	  String OpportunityTypeXpath="//div/select/option[contains(text(),'"+dropDownValue+"')]";
	    return Click.on(locator)
	        .then(Click.on(Target.the("OppType").locatedBy(OpportunityTypeXpath)));
	  }
	  else if(type=="Competition") {
		  String Xpath="//div/a[@class='select'][contains(text(),'"+dropDownValue+"')]";
		  return Click.on(locator)
			        .then(Click.on(Target.the("Competition").locatedBy(Xpath)));
	  }

	  else {
		  String path="//div[@class='listContent']/ul/li/a/div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']/div[@title='"+dropDownValue+"']";
		  return Click.on(locator)
			        .then(Click.on(Target.the("cpq").locatedBy(path)));
	  }
  }
public static void verifying(String value) {
	String xpath="//th[@class='slds-cell-edit cellContainer']/span/a[@title='"+value+"']";
	if(xpath!=null) {
		System.out.println("Opportunity is created");
	}
	else {
		System.out.println("Opportunity is not created");
	}
}

public static Performable searchAccount(String searchField,String EnterData,String testType) {
	
	String locator = UiFactory.getLocators.returnLocator(searchField);
	 String data = UiFactory.getTestData.returnTestData(testType,EnterData,searchField);
	return Enter.theValue(data)        
            .into(locator)
            .thenHit(Keys.ENTER);
}
public static void shadowLocator(Actor actor, String button,String element) throws InterruptedException {
	WebDriver driver=BrowseTheWeb.as(actor).getDriver();
	Actions action = new Actions(driver);
	if (element=="AddProducts") {
	driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='windowViewMode-normal oneContent active lafPageHost']/div/force-aloha-page/div/iframe")));
	WebElement root1 = driver.findElement(By.tagName("sb-page-container"));
	SearchContext shadowRoot1 = expandRootElement(root1,actor);
	System.out.println("root1 : "+root1);
	WebElement root2=shadowRoot1.findElement(By.cssSelector("sb-line-editor"));
	SearchContext shadowRoot2 = expandRootElement(root2,actor);
	System.out.println("root2 : "+root2);
	WebElement root3=shadowRoot2.findElement(By.cssSelector("sb-page-header"));
	System.out.println("root3 : "+root3);
	Thread.sleep(5000);
	WebElement root4=root3.findElement(By.cssSelector("div[id=actions] >sb-custom-action:nth-child(2)"));
	SearchContext shadowRoot3 = expandRootElement(root4,actor);
	System.out.println("root4 : "+root4);
	WebElement Addproducts=shadowRoot3.findElement(By.cssSelector("paper-button"));
	Addproducts.click();
	System.out.println("root5 : "+shadowRoot3);
	
	}
	else if(element=="Searchbar"){
		WebElement root1 = driver.findElement(By.tagName("sb-page-container"));
		SearchContext shadowRoot1 = expandRootElement(root1,actor);
		System.out.println("root1 : "+root1);
		WebElement root2=shadowRoot1.findElement(By.cssSelector("sb-product-lookup"));
		SearchContext shadowRoot2 = expandRootElement(root2,actor);
		System.out.println("root2 : "+root2);
		WebElement root3=shadowRoot2.findElement(By.cssSelector("sb-page-header"));
		System.out.println("root3 : "+root3);
		WebElement root4=root3.findElement(By.cssSelector("sb-search-bar"));
		SearchContext shadowRoot3 = expandRootElement(root4,actor);
		System.out.println("root4 : "+root4);
		WebElement root5=shadowRoot3.findElement(By.cssSelector("sb-typeahead"));
		SearchContext shadowRoot4 = expandRootElement(root5,actor);
		System.out.println("root5 : "+root5);
		WebElement root6=shadowRoot4.findElement(By.cssSelector("span >iron-input"));
		System.out.println("root6 : "+root6);
		WebElement root7=root6.findElement(By.cssSelector("input"));
		System.out.println("root7 : "+root6);
		root7.sendKeys("Business Plan");
		root7.sendKeys(Keys.ENTER);
	}
	else if(element=="Apply"){
		
		WebElement root1 = driver.findElement(By.tagName("sb-page-container"));
		SearchContext shadowRoot1 = expandRootElement(root1,actor);
		System.out.println("root1 : "+root1);
		WebElement root2=shadowRoot1.findElement(By.cssSelector("sb-product-lookup"));
		SearchContext shadowRoot2 = expandRootElement(root2,actor);
		System.out.println("root2 : "+root2);
		WebElement root3=shadowRoot2.findElement(By.cssSelector("paper-drawer-panel"));
		System.out.println("root3 : "+root3);
		root3.findElement(By.cssSelector("paper-button")).click();
	}
	else if(element=="productcode") {
	WebElement root1 = driver.findElement(By.tagName("sb-page-container"));
	SearchContext shadowRoot1 = expandRootElement(root1,actor);
	System.out.println("root1 : "+root1);
	WebElement root2=shadowRoot1.findElement(By.cssSelector("sb-product-lookup"));
	SearchContext shadowRoot2 = expandRootElement(root2,actor);
	System.out.println("root2 : "+root2);
	WebElement root3=shadowRoot2.findElement(By.cssSelector("paper-drawer-panel"));
	System.out.println("root3 : "+root3);
	WebElement root4=root3.findElement(By.cssSelector("sb-lookup-layout"));
	SearchContext shadowRoot3 = expandRootElement(root4,actor);
	System.out.println("root4 : "+root4);
	WebElement root5=shadowRoot3.findElement(By.cssSelector("sb-table-header"));
	SearchContext shadowRoot4 = expandRootElement(root5,actor);
	System.out.println("root5 : "+root5);
	WebElement root6=shadowRoot4.findElement(By.cssSelector("sb-group"));
	SearchContext shadowRoot5 = expandRootElement(root6,actor);
	System.out.println("root6 : "+root6);
	WebElement root7=shadowRoot5.findElement(By.cssSelector("sb-table-cell-select"));
	SearchContext shadowRoot6 = expandRootElement(root7,actor);
	shadowRoot6.findElement(By.cssSelector("paper-checkbox")).click();	
}
	else if(element=="select") {
		System.out.println("else");
		WebElement root1 = driver.findElement(By.tagName("sb-page-container"));
		SearchContext shadowRoot1 = expandRootElement(root1,actor);
		System.out.println("root1 : "+root1);
		WebElement root2=shadowRoot1.findElement(By.cssSelector("sb-product-lookup"));
		SearchContext shadowRoot2 = expandRootElement(root2,actor);
		System.out.println("root2 : "+root2);
		WebElement root4=shadowRoot2.findElement(By.cssSelector("sb-page-header"));
		System.out.println("root3 : "+root4);
		root4.findElement(By.cssSelector("paper-button[id=plSelect]")).click();
	}
	else if(element=="quantity") {
		
		WebElement root1 = driver.findElement(By.tagName("sb-page-container"));
		SearchContext shadowRoot1 = expandRootElement(root1,actor);
		System.out.println("root1 : "+root1);
		WebElement root2=shadowRoot1.findElement(By.cssSelector("sb-line-editor"));
		SearchContext shadowRoot2 = expandRootElement(root2,actor);
		System.out.println("root2 : "+root2);
		WebElement root3=shadowRoot2.findElement(By.cssSelector("sb-le-group-layout"));
		SearchContext shadowRoot3 = expandRootElement(root3,actor);
		System.out.println("root3 : "+root3);
		WebElement root4=shadowRoot3.findElement(By.cssSelector("sb-le-group"));
		SearchContext shadowRoot4 = expandRootElement(root4,actor);
		System.out.println("root4 : "+root4);
		WebElement root5=shadowRoot4.findElement(By.cssSelector("sf-standard-table"));
		SearchContext shadowRoot5 = expandRootElement(root5,actor);
		System.out.println("root5 : "+root5);
		WebElement root6=shadowRoot5.findElement(By.cssSelector("sf-le-table-row"));
		SearchContext shadowRoot6 = expandRootElement(root6,actor);
		System.out.println("root6 : "+root6);
		WebElement Quantity=shadowRoot6.findElement(By.cssSelector("div[field=SBQQ__Quantity__c]"));
		action.doubleClick(Quantity).build().perform();
		System.out.println("Doubleclick done");
		Quantity.sendKeys("100.00");
		System.out.println("updated");
		
	}
	else {
		WebElement root1 = driver.findElement(By.tagName("sb-page-container"));
		SearchContext shadowRoot1 = expandRootElement(root1,actor);
		System.out.println("root1 : "+root1);
		WebElement root2=shadowRoot1.findElement(By.cssSelector("sb-line-editor"));
		SearchContext shadowRoot2 = expandRootElement(root2,actor);
		System.out.println("root2 : "+root2);
		WebElement root3=shadowRoot2.findElement(By.cssSelector("sb-le-group-layout"));
		System.out.println("root3 : "+root3);
		WebElement root4=root3.findElement(By.cssSelector("sb-field-set-table"));
		SearchContext shadowRoot4 = expandRootElement(root4,actor);
		System.out.println("root4 : "+root4);
		WebElement root5=shadowRoot4.findElement(By.cssSelector("sb-group[id=thirdColumn]"));
		SearchContext shadowRoot5 = expandRootElement(root5,actor);
		System.out.println("root5 : "+root5);
		WebElement root6=shadowRoot5.findElement(By.cssSelector("div[id=g] >div >sb-field-set-table-item:nth-child(3)"));
		SearchContext shadowRoot6 = expandRootElement(root6,actor);
		System.out.println("root6 : "+root6);
		WebElement root7=shadowRoot6.findElement(By.cssSelector("sb-field"));
		SearchContext shadowRoot7 = expandRootElement(root7,actor);
		System.out.println("root7 : "+root7);
		WebElement root8=shadowRoot7.findElement(By.cssSelector("sb-checkbox"));
		SearchContext shadowRoot8 = expandRootElement(root8,actor);
		System.out.println("root8 : "+root8);
		WebElement CalculateQuoteTotal=shadowRoot8.findElement(By.cssSelector("paper-checkbox"));
		System.out.println("root9 : "+CalculateQuoteTotal);
		CalculateQuoteTotal.click();
		
	}
}
public static SearchContext expandRootElement(WebElement element,Actor actor) {
	WebDriver driver=BrowseTheWeb.as(actor).getDriver();
	SearchContext ele = (SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
	return ele;
}
public static void waitForElementVisibility(WebDriver driver, String elementId, int maxWaitTime, int checkInterval) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime), Duration.ofSeconds(checkInterval));

 Instant startTime = Instant.now();
 WebElement element = null;

 while (Duration.between(startTime, Instant.now()).getSeconds() < maxWaitTime) {
     try {
         element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
         break;
     } catch (Exception e) {}
 }

 if (element == null) {
     throw new Exception("Timed out waiting for element to be visible");
 }
}
public static void waiting(Actor actor,String path) {
    WebDriver driver = BrowseTheWeb.as(actor).getDriver();
    try {
        //System.out.println("wainting in the  try case -----------");
        waitForElementVisibility(driver, path, 30, 1);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
