package stepsDefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		
	@When("I enter {string} into productBox and search for the product")
	public void i_enter_into_productBox_and_search_for_the_product(String validProduct) throws InterruptedException {
		try {
    		base.log.info("* When the user enters " + validProduct + " into product box ");
    		base.keyword.waitUntilElementIsVisible("productBox");
    		base.keyword.searchforProduct(validProduct);
    		base.keyword.sleep(Constants.sleepTimeOneSecond);		
    	} catch (Exception e) {
    		base.log.fatal("Exception - User inputs product");
    		Assert.fail(e.getMessage());
    	} 
	}

	@When("I add the selected product to the basket")
	public void i_add_the_selected_product_to_the_basket() throws InterruptedException {		
	   try {
	      base.keyword.addProductToBasket();
	   } catch (Exception e) {
		  base.log.fatal("Exception - User adds selected product to the basket");
   		  Assert.fail(e.getMessage());
	   }
	}

	@When("I go to the basket")
	public void i_go_to_the_basket() throws InterruptedException {
	   try {
		base.keyword.getToBasket();
	   } catch (AssertionError e) {
		   base.log.fatal("Exception - User loads the basket page");
	   	   Assert.fail(e.getMessage());
	   }
	}
	
	@Then("the basketProduct should contain {string}")
	public void the_basketProduct_should_contain(String searchProduct) throws InterruptedException {
		try {
			base.log.info("* Then the basketProduct should contain" + searchProduct);
	    		    		
			base.keyword.waitUntilPageLoadsComplelety();
			base.keyword.waitUntilElementIsVisible("basketProduct");
			
			WebElement table = base.keyword.getElement("basketProduct");
			List<WebElement> rows = table.findElements(By.tagName("tr"));		
			 
			String actual = rows.get(2).getText();      		 
			
			boolean productAdded = base.keyword.verifyPartialText(actual.toString(), searchProduct);
			
			// Compare
			Assert.assertTrue(productAdded);
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
