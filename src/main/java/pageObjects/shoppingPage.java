package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utils.waitBase;

public class shoppingPage extends waitBase {

	WebDriver driver;

	public shoppingPage(WebDriver driver) {
	super(driver);
	}

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartBtn;
	
	@FindBy(css = "button[routerlink='/dashboard']")
	WebElement cartBackBtn;
	
	@FindBy(css = ".col-lg-4")
	List<WebElement> shoppingList;
	
	@FindBy(css = ".card .card-body h5[style*='text-transform']")
	List<WebElement> itemsName;
	
	@FindBy(css = ".card .card-body button[class*=w-40]")
	List<WebElement> itemsViewBtns;  
	
	@FindBy(css = ".col-lg-6 div h2")
	WebElement itemTitleInProdDetailPage;
	 
	public void clickCartButton(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
		cartBtn.click();
	}

	public void clickContinueShoppingBtn(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(cartBackBtn));
		cartBackBtn.click();
	}

	public List<WebElement> getAllShoppingListItems(WebDriver driver) {
		wait.until(ExpectedConditions.visibilityOfAllElements(shoppingList));
		return shoppingList;	
	}

	public void selectingPurchaseItem(String purchaseItemName) {
		for(int i=0;i<itemsName.size();i++) {
			if(itemsName.get(i).getText().equalsIgnoreCase(purchaseItemName)) {
				itemsViewBtns.get(i).click();
				break;
			}
		}
	}
		
	public String getProductDetailsTitle(String getProductDetailURL) {
		wait.until(ExpectedConditions.urlContains(getProductDetailURL));
		wait.until(ExpectedConditions.visibilityOf(itemTitleInProdDetailPage));
		wait.until(d -> !itemTitleInProdDetailPage.getText().trim().isEmpty());
		return itemTitleInProdDetailPage.getText();
	}
}
