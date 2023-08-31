Feature: Sample usecase test
    @ui
    Scenario: open the firstlink which appears when a keyword is searched
    Given user is on Application homepage
    Then he logs in to the application "scenario" by entering "username" and "password" then clicking the "loginbtn" button using data "<csvdata>"
    And he clicks on "Sendpush" button
    
    ###Create Opportunity
    
    And he clicks on "Accounts" link
    And he searches for Accountname in "AccountName" using "<csvdata>" and hits enter
    And he clicks on "Accountname"
    And he clicks on AccountName "Accountname" using "<csvdata>"
    Then he clicks on CreateOpportunity "CreateOpportunity"
    And he clicks "OpportunityType" dropdown and selects "Sales"
    Then he clicks on nextbutton "Nextbutton"
    And he enters the "Email" in the textbox using "<csvdata>"
    Then he clicks on nbtn "Nextbtn"
    And he enters ContactFirstname "ContactFirstname" ContactLastname "ContactLastname" using "<csvdata>"
    Then he clicks on nextbtn "Nextbtn"
    And he enters "Opportunity_Name" using "<csvdata>"
    And he clicks "Choose_A_Product" dropdown and chooses "Premium"
    And he enters "No_of_Seats" and "Close_date" using "<csvdata>"
    And he enter currency "Currency" using "USD"
    Then he clicks on nxtbtn "Nextbtn"
    And he clicks on finish "Finish"
    And he clicks on "VerifyOpportunity" to verify
   
    
    ## Creating CPQ Quote
    
    And he searches for OpportunityName in "OpportunityNameSearch" using "<csvdata>" and hits enter
    Then he clicks on Opportunityname "Opportunityname"
    Then he clicks on CPQquote "CPQquote" button
    Then he clicks on Primary "primary" checkbox
    Then he clicks on primarycontact "primarycontact" and selects "tester Chandana"
    And he enters CPQdate "CPQdate" using "<csvdata>"
    And he enters CPQ Subscription in "CPQSubscription" using "<csvdata>"
    And he clicks on save "save" button
    
    ###AddProducts
    
    Then he clicks on Quotes "Quotes" link
    And he clicks on Quotenumber "Quotenumber"
    And he clicks on EditLines "Editlines"
    And he clicks on Addproducts "Addproducts" button
    And he clicks on searchbar "root6" and hits enter
    And he clicks on Apply "root3" button
    And he checks the Productcode "shadowRoot7"
    And he clicks on select "root4"
    And he clicks on quantity "Quantity" to update it
    And he clicks on Calculate Quote Total checkbox "CalculateQuoteTotal"
    
 Examples:
      |csvdata |
      |TestCase2 |
      
		#And he searches for OpportunityName "VarSearchField" using "<csvdata>"
    #Then he clicks on stage0 "stage0"
    #Then he clicks on stage1 "stage1"
    #Then he clicks on Edit "Edit"
    #Then he clicks on "Competition" and selects competition "Asana Business"
    #Then he clicks on stage2 "stage2"