package webConnector;

import util.BaseUtil;

public class AppSpecificKeywords extends GenericKeywords {

	public AppSpecificKeywords(BaseUtil base) {
		super(base);
	}

	public void getToSignInPage() {
		try {
			base.log.info("Loading Home Page");

			base.keyword.waitUntilElementIsVisible("homePageHeader");
			//click the Cookies link at the top of the page
			base.keyword.click("cookiesLink");
			base.keyword.waitUntilPageLoadsComplelety();
		} catch (Exception e) {
			base.log.info(e.getMessage());
		}
	}

	public void searchforProduct(String data) {
		try {
			base.log.info("Check if the Search box is loaded");
			base.keyword.waitUntilElementIsVisible("productBox");

			// Enter product name
			base.log.info("Enter Product in Search box and click Search");
			base.keyword.type("productBox", data);

			// Click search button
			base.keyword.click("searchButton");

		} catch (Exception e) {
			base.log.info(e.getMessage());
		}
	}

	public void addProductToBasket() {
		try {

			base.log.info("Adding the first Product from search results to the product basket");
			
			base.keyword.waitUntilPageLoadsComplelety();
			base.keyword.waitUntilElementIsVisible("addButton");
			
			// Click add to basket button 
			base.keyword.click("addButton");
			
		} catch (Exception e) {
			base.log.info(e.getMessage());
		}
	}

	public void getToBasket() {
		try {

			// Open product basket to validate the result
			base.log.info("Click on Product Basket");
			base.keyword.click("viewBasketLink");
			
			
		} catch (Exception e) {
			base.log.info(e.getMessage());
		}
	}

}
