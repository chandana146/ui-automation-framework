package stl.ui.automation.framework.stepimplementation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import stl.ui.automation.framework.base.ui.navigation.NavigateTo;
import stl.ui.automation.framework.base.ui.tasks.Tasks;


public class StepDefinitions {
  @Given("{actor} is on Application homepage")
  public void openWebPage(Actor actor){
    actor.wasAbleTo(NavigateTo.theApplicationHomePage());
   Tasks.explicitWait();
  } 
@Then("{actor} logs in to the application {string} by entering {string} and {string} then clicking the {string} button using data {string}")
 public void he_logs_in_to_the_application_by_entering_and_then_clicking_the_button_using_data_test_case1(Actor actor,
		 String testtype,String username,String password,String loginButton,String data){
	 String loginDetails=username+","+password;
	 actor.attemptsTo(Tasks.loginIntoApplication("CSVlogin",username,password,loginButton,loginDetails,data));
	 Tasks.explicitWait();
	 Tasks.explicitWait();
	 Tasks.explicitWait();
 }
 
 @And("{actor} clicks on {string} button")
 public void clickAButton(Actor actor, String Sendpush){
   //actor.attemptsTo(Tasks.clickAction(Sendpush));
	 actor.attemptsTo(Tasks.javascriptClickAction(Sendpush));
	Tasks.waiting(actor, Sendpush);
}
 @And("{actor} clicks on {string} link")
 public void clickAlink(Actor actor, String Accounts){
	 actor.attemptsTo(Tasks.javascriptClickAction(Accounts));
	 Tasks.explicitWait();
	 Tasks.explicitWait();
}
 @And("{actor} clicks on AccountName {string} using {string}")
 public void clickAccountname(Actor actor,String Accountname, String csvdata){
	 actor.attemptsTo(Tasks.clickALink(Accountname, csvdata,"CSV"));
	 System.out.println("AccountName " + Accountname);
	 System.out.println("csvdata "+csvdata);
}
 @And("{actor} searches for Accountname in {string} using {string} and hits enter")
 public void Accountnamelink(Actor actor,String AccountName, String csvdata){
	 actor.attemptsTo(Tasks.searchAccount(AccountName,csvdata,"CSV"));
}
 @Then("{actor} clicks on {string}")
 public void AccnameLink(Actor actor, String Accountname){
	 actor.attemptsTo(Tasks.javascriptClickAction(Accountname));
	 Tasks.explicitWait();
	      
 }
 @Then("{actor} clicks on CreateOpportunity {string}")
 public void CreateOpportunity(Actor actor, String CreateOpportunity){
	 actor.attemptsTo(Tasks.javascriptClickAction(CreateOpportunity));
	 Tasks.explicitWait();
	      
 }
 @And("{actor} clicks {string} dropdown and selects {string}")
 public void OpportunityType(Actor actor, String dropdown, String dropDownValue){
	 actor.attemptsTo(Tasks.selectsDropDown(dropdown, dropDownValue,"Account"));
	 
}
 @And("{actor} clicks on nextbutton {string}")
 public void nextbutton(Actor actor, String Nextbutton){
	 actor.attemptsTo(Tasks.javascriptClickAction(Nextbutton));
}
 @And("{actor} enters the {string} in the textbox using {string}")
 public void enteremail(Actor actor, String Email, String csvdata){
	 actor.attemptsTo(Tasks.enterAValue(csvdata, Email, "CSV"));
}
 @And("{actor} clicks on nextbtn {string}")
 public void nextbtn(Actor actor, String Nextbtn){
	 actor.attemptsTo(Tasks.javascriptClickAction(Nextbtn));
	 Tasks.explicitWait();
}
 @And("{actor} enters ContactFirstname {string} ContactLastname {string} using {string}")
 public void enteremail(Actor actor, String ContactFirstname, String ContactLastname, String csvdata){
	 actor.attemptsTo(Tasks.enterAValue(csvdata,ContactFirstname , "CSV"));
	 actor.attemptsTo(Tasks.enterAValue(csvdata, ContactLastname, "CSV"));
}
 @And("{actor} clicks on nbtn {string}")
 public void nbtn(Actor actor, String Nextbutton){
	 actor.attemptsTo(Tasks.javascriptClickAction(Nextbutton));
	 Tasks.explicitWait();
}
 @And("{actor} enters {string} using {string}")
 public void entermail(Actor actor, String Opportunity_Name, String csvdata){
	 actor.attemptsTo(Tasks.enterAValue(csvdata, Opportunity_Name, "CSV"));
	 Tasks.explicitWait();
	
}
 @And("{actor} clicks {string} dropdown and chooses {string}")
 public void chooseAProduct(Actor actor, String dropdown, String dropDownValue){
	 actor.attemptsTo(Tasks.selectsDropDown(dropdown, dropDownValue,"Account"));
	 Tasks.explicitWait();
}
 @And("{actor} enters {string} and {string} using {string}")
 public void enterdetails(Actor actor, String No_of_Seats,String Close_date, String csvdata){
	 actor.attemptsTo(Tasks.enterAValue(csvdata, No_of_Seats, "CSV"));
	 actor.attemptsTo(Tasks.enterAValue(csvdata, Close_date, "CSV"));
}
 //@And("{actor} clicks {string} dropdown and selects the currency {string}")
 @And("{actor} enter currency {string} using {string}")
 public void chooseOpportunity_Currency(Actor actor, String dropdown, String dropDownValue){
	 Tasks.moveMouseToLocation(dropdown);
	 actor.attemptsTo(Tasks.selectsDropDown(dropdown, dropDownValue,"Account"));
	 Tasks.explicitWait();
	 
 }
 @And("{actor} clicks on nxtbtn {string}")
 public void nxtbtn(Actor actor, String Nextbutton){
	 actor.attemptsTo(Tasks.javascriptClickAction(Nextbutton));
	 Tasks.explicitWait();
	 
}
 @And("{actor} clicks on finish {string}")
 public void finish(Actor actor, String Nextbutton){
	 Tasks.waiting(actor, Nextbutton);
	 actor.attemptsTo(Tasks.javascriptClickAction(Nextbutton));
	 Tasks.explicitWait();
}
 @And("{actor} clicks on {string} to verify")
 public void verifyOpp(Actor actor, String Opportunites){
	 actor.attemptsTo(Tasks.javascriptClickAction(Opportunites));
	 Tasks.explicitWait();
	 Tasks.explicitWait();
}
 @And("{actor} searches for OpportunityName {string} using {string}")
 public void SearchOpp(Actor actor, String value, String csvdata){
	Tasks.verifying(value);
}
 @And("{actor} searches for OpportunityName in {string} using {string} and hits enter")
 public void OpportunityNamelink(Actor actor,String OpportunityNameSearch, String csvdata){
	 Tasks.waiting(actor, OpportunityNameSearch);
	 actor.attemptsTo(Tasks.searchAccount(OpportunityNameSearch,csvdata,"CSV"));
	 Tasks.explicitWait();
}
 @Then("{actor} clicks on Opportunityname {string}")
 public void OpportunitynameLink(Actor actor, String Opportunityname){
	 actor.attemptsTo(Tasks.javascriptClickAction(Opportunityname));
	 Tasks.explicitWait();	
	 Tasks.explicitWait();
 }
 @Then("{actor} clicks on stage0 {string}")
 public void stage0Link(Actor actor, String stage0){
	 Tasks.explicitWait();
	 actor.attemptsTo(Tasks.javascriptClickAction(stage0));
	 Tasks.explicitWait();	 
	 Tasks.explicitWait();
 }
 @Then("{actor} clicks on stage1 {string}")
 public void stage1Link(Actor actor, String stage1){
	 actor.attemptsTo(Tasks.javascriptClickAction(stage1));
	 Tasks.explicitWait();	  
	 Tasks.explicitWait();
 }
 @Then("{actor} clicks on Edit {string}")
 public void EditLink(Actor actor, String Edit){
	 actor.attemptsTo(Tasks.javascriptClickAction(Edit));
	 Tasks.explicitWait();	
	 Tasks.explicitWait();
	 Tasks.explicitWait();
 } 
 @Then("{actor} clicks on stage2 {string}")
 public void stage2Link(Actor actor, String stage2){
	 actor.attemptsTo(Tasks.javascriptClickAction(stage2));
	 Tasks.explicitWait();	      
	 Tasks.explicitWait();	
	 Tasks.explicitWait();	
 }
 @Then("{actor} clicks on {string} and selects competition {string}")
 public void stage2Link(Actor actor, String dropdown, String dropDownValue){
	 actor.attemptsTo(Tasks.selectsDropDown(dropdown, dropDownValue, "Competition"));
	 Tasks.explicitWait();	    
	 Tasks.explicitWait();	
	
 }
 @Then("{actor} clicks on CPQquote {string} button")
 public void CPQquote(Actor actor, String CPQquote){
	 Tasks.waiting(actor, CPQquote);
	 actor.attemptsTo(Tasks.javascriptClickAction(CPQquote));
	 Tasks.explicitWait();
 }
 @Then("{actor} clicks on Primary {string} checkbox")
 public void primary(Actor actor, String primary){
	 Tasks.waiting(actor, primary);
	 actor.attemptsTo(Tasks.clickCheckBox(primary));	
 }
 @And("{actor} clicks on primarycontact {string} and selects {string}")
 public void primarycontact(Actor actor, String dropdown, String dropDownValue){
	 Tasks.moveMouseToLocation(dropdown);
	 actor.attemptsTo(Tasks.selectsDropDown(dropdown, dropDownValue,"cpq"));
	 
 }
 @And("{actor} selects the account {string} as {string}")
 public void cpqaccount(Actor actor, String dropdown, String dropDownValue){
	 actor.attemptsTo(Tasks.selectsDropDown(dropdown, dropDownValue,"cpq")); 
 }
 @And("{actor} enters CPQdate {string} using {string}")
 public void enterDate(Actor actor, String CPQdate, String csvdata){
	 Tasks.waiting(actor, CPQdate);
	 actor.attemptsTo(Tasks.enterAValue(csvdata, CPQdate, "CSV"));
}
 @And("{actor} enters CPQ Subscription in {string} using {string}")
 public void he_enters_cpq_subscription_in_using(Actor actor, String subscription, String csvdata) {
     actor.attemptsTo(Tasks.enterAValue(csvdata, subscription, "csv"));
     //Tasks.explicitWait();

 }
 @And("{actor} clicks on save {string} button")
 public void save(Actor actor, String save){
	 actor.attemptsTo(Tasks.javascriptClickAction(save));
	 Tasks.explicitWait();
	 Tasks.explicitWait();
}
 @And("{actor} clicks on Quotes {string} link")
 public void Quotes(Actor actor, String Quotes){
	 actor.attemptsTo(Tasks.javascriptClickAction(Quotes));
	 Tasks.explicitWait();
	 Tasks.explicitWait();
}
 @And("{actor} clicks on Quotenumber {string}")
 public void Quotenumber(Actor actor, String Quotenumber){
	 actor.attemptsTo(Tasks.javascriptClickAction(Quotenumber));
	 Tasks.explicitWait();
	 Tasks.explicitWait();
	 Tasks.explicitWait();
}
 @And("{actor} clicks on EditLines {string}")
 public void Editlines(Actor actor, String Editlines){
	 Tasks.explicitWait();
	 actor.attemptsTo(Tasks.javascriptClickAction(Editlines));
	 Tasks.explicitWait();
	 Tasks.explicitWait();
	 Tasks.explicitWait();
	 Tasks.explicitWait();

 } 
 @And("{actor} clicks on Addproducts {string} button")
 public void Addproducts(Actor actor,String shadowRoot3) throws InterruptedException{
	 Tasks.explicitWait();
	 Tasks.shadowLocator(actor, shadowRoot3,"AddProducts");
	 Tasks.explicitWait();
	 Tasks.explicitWait();
	 Tasks.explicitWait();

 } 
 @And("{actor} clicks on searchbar {string} and hits enter")
 public void Searchbar(Actor actor,String root6) throws InterruptedException{
	 Tasks.shadowLocator(actor, root6,"Searchbar");
	 Tasks.explicitWait();
 } 
 @And("{actor} clicks on Apply {string} button")
 public void Applybtn(Actor actor,String root3) throws InterruptedException{
	 Tasks.shadowLocator(actor, root3,"Apply");
	 Tasks.explicitWait();
 } 
 @And("{actor} checks the Productcode {string}")
 public void Productcode(Actor actor,String shadowRoot7) throws InterruptedException{
	 Tasks.explicitWait();
	 Tasks.shadowLocator(actor, shadowRoot7,"productcode");
	 Tasks.explicitWait();
 } 
 @And("{actor} clicks on select {string}")
 public void selectbtn(Actor actor,String root4) throws InterruptedException{
	 Tasks.explicitWait();
	 Tasks.shadowLocator(actor, root4,"select");
	 Tasks.explicitWait();
	 Tasks.explicitWait();
 } 
 @And("{actor} clicks on quantity {string} to update it")
 public void he_clicks_on_quantity_to_update_it(Actor actor,String Quantity) throws InterruptedException {
	 Tasks.shadowLocator(actor, Quantity,"quantity");
	 Tasks.explicitWait();
	 Tasks.explicitWait();
	 
 }
 @And("{actor} clicks on Calculate Quote Total checkbox {string}")
 public void he_clicks_on_Calculate_Quote_Total_checkbox(Actor actor,String Quotetotal) throws InterruptedException {
	 Tasks.explicitWait();
	 Tasks.explicitWait();
	 Tasks.shadowLocator(actor, Quotetotal,"quotetotal");
	 Tasks.explicitWait();
	 Tasks.explicitWait();
	 Tasks.explicitWait();
 }
}


