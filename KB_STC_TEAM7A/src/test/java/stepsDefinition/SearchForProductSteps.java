package stepsDefinition;

import org.junit.Assert;
import org.openqa.selenium.By.ByXPath;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.BaseUtil;
import util.Constants;


//Step Layer
public class SearchForProductSteps extends BaseUtil {
	public BaseUtil base;
	
	public SearchForProductSteps(BaseUtil base) {
		this.base = base;
}
	@Given("when I am on the homepage")
	public void when_I_am_on_the_homepage() throws InterruptedException {
		 try {
		    	base.log.info("Get to the website.....");
		    	
		    	// Get to sign in page
		    	base.keyword.getToSignInPage();
		    	
		    	// check element exists
				boolean result = base.keyword.checkElementExists("homePageHeader");
				Assert.assertTrue(result);
				base.log.info("User is on the home page");
			}  catch (Exception e) {
				base.log.fatal("Exception - User is NOT on the Home page");
				Assert.fail(e.getMessage());
			} catch (AssertionError e) {
				base.log.error("AssertionError - User is NOT on the Home page");
				Assert.fail(e.getMessage());
			}
	}
	

	@When("I enter {string} into {string} and search for the product")
	public void i_enter_into(String validProduct, String productBox) throws InterruptedException {
    	try {
    		base.log.info("* When the user enters " + validProduct + " into " + productBox);
    		base.keyword.waitUntilElementIsVisible(productBox);
    		base.keyword.searchforProduct(validProduct);
    		base.keyword.sleep(Constants.sleepTimeOneSecond);		
    	} catch (Exception e) {
    		base.log.fatal("Exception - User inputs product");
    		Assert.fail(e.getMessage());
    	} 
    }
		

	@When("I add the selected product to the basket")
	public void i_add_the_selected_product_to_the_basket() throws InterruptedException {
	   base.keyword.addProductToBasket();
	}

	@When("I go to the basket")
	public void i_go_to_the_basket() throws InterruptedException {
	   base.keyword.getToBasket();
	}
	
	@Then("the {string} should be available in the basket")
	public void the_should_be_available_in_the_basket(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Then("the {string} should contain {string}")
	public void the_should_contain(String basketProduct, String product) {
		try {
			base.log.info("* Then the " + basketProduct + "should contain keyboard");
	
		    String actual = base.keyword.readLabel(basketProduct);
		    product = "Keyboard";
		    
			// Compare
			Assert.assertTrue(actual.contains(product));
			base.log.info("Search For Product Test has passed");

		} catch (Exception e) {
			base.log.fatal("Exception - Product Basket page");
			Assert.fail(e.getMessage());
		} catch (AssertionError e) {
			base.log.error("AssertionError - Product Basket page");
			Assert.fail(e.getMessage());
		}
	}
}
