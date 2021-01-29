package com.opentext.businessnetwork.BNSUI.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opentext.bn.core.UI;
import com.opentext.bn.core.Util;

public class BNSUIOperation {
	
	public WebDriverWait wait;
	
	public BNSUIOperation() {
		wait = new WebDriverWait(UI.getdriver(), 20); 
		PageFactory.initElements(UI.getdriver(), this);
	}
	
	@FindBy(xpath="//mat-header-cell[contains(text(),'Name')]/../following-sibling::mat-row/mat-cell[contains(text(),' Kubasad, ')]/../descendant::div[contains(@class,'no')]")
	WebElement elementSenderEmailAddress;
	
	@FindBy(xpath="//input[@placeholder='From address']")
	WebElement elementFromAddress;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchInput;
	
	@FindBy(xpath="//input[@placeholder='Select Recepient(s)']")
	WebElement elementToRecipients;
	
	@FindBy(xpath="//div[contains(text(),'Sender Contacts')]")
	WebElement elementSenderContacts;
	
	@FindBy(xpath="//div[contains(text(),'Receiver Contacts')]")
	WebElement elementReceiverContacts;
	
	@FindBy(xpath="//div[contains(text(),'Support Contacts')]")
	WebElement elementSupportContacts;
	
	@FindBy(xpath="//div[contains(text(),'Selected Recepients')]")
	WebElement elementSelectedRecepients;
	
	@FindBy(xpath="//span[contains(text(),'Add')]")
	WebElement elementAdd;
	
	@FindBy(xpath="//input[@placeholder='Select Cc(s)']")
	WebElement elementCcRecipients;
	
	@FindBy(xpath="//input[@placeholder='Select Bcc(s)']")
	WebElement elementBCcRecipients;
	
	@FindBy(xpath="//input[@formcontrolname='transactionId']")
	WebElement elementTransactionId;
	
	@FindBy(xpath="//mat-select[@role='listbox']")
	WebElement elementList;
	
	@FindBy(xpath="//button[@aria-label='Next page']")
	WebElement elementNextPage;
	
	@FindBy(xpath="//button[@aria-label='Previous page']")
	WebElement elementPreviousPage;

	@FindBy(xpath="//span[contains(text(),'Submit')]")
	WebElement elementSubmit;
	
	@FindBy(xpath="//button[text()='Send']")
	WebElement elementSend;
	
	@FindBy(xpath="//li[contains(text(),' Logout')]")
	WebElement elementLogout;
	
	@FindBy(xpath="//button[@role='button']")
	WebElement elementLogoutButton;
	
	
	public void enteringTransactionID(String TransactionID) {
		System.out.println("Entering Transaction ID");
		Util.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(elementTransactionId)).sendKeys(TransactionID);
		UI.Click(elementSubmit);
		System.out.println("Loaded url with transaction id");
		Util.sleep(40000);
		UI.verifyExists_ByXPATH("//input[@placeholder='From address']");
		Util.sleep(3000);
	}

	public void selectingRecipients(String tcName) {
		if (tcName.equals("VerificationofFailedStatus")) {
			selectingToRecipients();
			selectingCcsRecipients();
			selectingBCCsRecipients();
		} else if(tcName.equals("VerificationforDeliveredStatus")) {
			selectingToRecipients();
			selectingCcsRecipients();
			selectingBCCsRecipients();
		}else if (tcName.equals("VerificationForReadyForPickUp")) {
			selectingToRecipients();
			selectingCcsRecipients();
			selectingBCCsRecipients();
		}else if (tcName.equals("VerificationForProcessingStatus")) {
			selectingToRecipients();
			selectingCcsRecipients();
		}else if (tcName.equals("VerificationForCompletedStatus")) {
			selectingToRecipients();
			selectingCcsRecipients();
		}else if (tcName.equals("VerificationForBestMatchRule")) {
			System.out.println("Clicking on ToRecipient text");
			wait.until(ExpectedConditions.elementToBeClickable(elementToRecipients)).click();
			System.out.println("Clicked on ToRecipient text");
			wait.until(ExpectedConditions.elementToBeClickable(elementSenderContacts)).click();
			UI.verifyPass("To verify the Sender Contacts for Best Match Rule", "Displayed Best Match Rule for Sender Contacts", "Displayed Best Match Rule for Sender Contacts");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-header-cell[contains(text(),'Name')]/../following-sibling::mat-row/mat-cell[contains(text(),' Holla, ')]/../descendant::div[contains(@class,'no')]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(elementAdd)).click();
			System.out.println("Clicked on Add Button");
			UI.Click(elementBCcRecipients);
			System.out.println("Clicked on BCcsRecipient text");
			wait.until(ExpectedConditions.elementToBeClickable(elementReceiverContacts)).click();
			UI.verifyPass("To verify the Receiver Contacts for Best Match Rule", "Displayed Best Match Rule for Receiver Contacts", "Displayed Best Match Rule for Receiver Contacts");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-header-cell[contains(text(),'Name')]/../following-sibling::mat-row/mat-cell[contains(text(),' Holla 2093, Reshma ')]/../descendant::div[contains(@class,'no')]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(elementSelectedRecepients)).click();
			UI.verifyPass("To verify the Best Match Rule Contacts", "Displaying the Best Match Rule Contacts", "Displayed in Selected Receipients");
			wait.until(ExpectedConditions.elementToBeClickable(elementAdd)).click();
			System.out.println("Clicked on Add Button");
		}else
			System.out.println("This is just for verification :");
	}

	public void selectingToRecipients() {
		System.out.println("Clicking on ToRecipient text");
		Util.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(elementToRecipients)).click();
		Util.sleep(3000);
		System.out.println("Clicked on ToRecipient text");
		Util.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(elementSenderContacts)).click();
		Util.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(elementList)).click();
		Util.sleep(3000);
		List<WebElement> dropDownElements = UI.getdriver().findElements(By.cssSelector("span.mat-option-text"));
		for(WebElement dropDown : dropDownElements) {
			if(dropDown.getText().contains("20"))
				dropDown.click();
		}
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-header-cell[contains(text(),'Name')]/../following-sibling::mat-row/mat-cell[contains(text(),' Kubasad, ')]/../descendant::div[contains(@class,'no')]"))).click();
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementSupportContacts)).click();
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-header-cell[contains(text(),'Name')]/../following-sibling::mat-row/mat-cell[contains(text(),' Holla, ')]/../descendant::div[contains(@class,'no')]"))).click();
		Util.sleep(2000);
		System.out.println("Clicked on checkbox");
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementSelectedRecepients)).click();
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-cell[contains(text(),' rkubasad@opentext.com ')]/following-sibling::mat-cell/img"))).click();
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementAdd)).click();
		System.out.println("Clicked on Add Button");
		Util.sleep(3000);
	}

	public void selectingCcsRecipients() {
		UI.Click(elementCcRecipients);
		Util.sleep(2000);
		System.out.println("Clicked on CcsRecipient text");
		Util.sleep(2000);
		UI.Click(elementSenderContacts);
		Util.sleep(2000);
		UI.Click(elementList);
		Util.sleep(2000);
		List<WebElement> dropDownElements = UI.getdriver().findElements(By.cssSelector("span.mat-option-text"));
		for(WebElement dropDown : dropDownElements) {
			if(dropDown.getText().contains("20"))
				dropDown.click();
		}
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-header-cell[contains(text(),'Name')]/../following-sibling::mat-row/mat-cell[contains(text(),' Holla, Reshma ')]/../descendant::div[contains(@class,'no')]"))).click();
		Util.sleep(2000);
		System.out.println("Clicked on checkbox");
		Util.sleep(2000);
		UI.verifyExists_ByXPATH("//mat-header-cell[contains(text(),'Name')]/../following-sibling::mat-row/mat-cell[contains(text(),' Holla, Reshma ')]/../descendant::div[contains(@class,'no')]");
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementSelectedRecepients)).click();
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementAdd)).click();
		Util.sleep(2000);
		System.out.println("Clicked on Add Button");
		Util.sleep(3000);
	}

	public void selectingBCCsRecipients() {
		Util.sleep(2000);
		UI.Click(elementBCcRecipients);
		Util.sleep(2000);
		System.out.println("Clicked on BCcsRecipient text");
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementReceiverContacts)).click();
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementList)).click();
		Util.sleep(2000);
		List<WebElement> dropDownElements = UI.getdriver().findElements(By.cssSelector("span.mat-option-text"));
		for(WebElement dropDown : dropDownElements) {
			if(dropDown.getText().contains("20"))
				dropDown.click();
		}
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-header-cell[contains(text(),'Name')]/../following-sibling::mat-row/mat-cell[contains(text(),' 775 Gmail, Reshma ')]/../descendant::div[contains(@class,'no')]"))).click();
		Util.sleep(2000);
		System.out.println("Clicked on checkbox");
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementAdd)).click();
		Util.sleep(2000);
		System.out.println("Clicked on Add Button");
	}
	
	public void checkboxFunction(String tcName) {
		if (tcName.equals("Verificationofotheroperations")) {
			Util.sleep(2000);
			System.out.println("Clicking on ToRecipient text");
			Util.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(elementToRecipients)).click();
			Util.sleep(2000);
			System.out.println("Clicked on ToRecipient text");
			Util.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(elementSenderContacts)).click();
			Util.sleep(2000);
			System.out.println("Click on Next Page Button");
			Util.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(elementNextPage)).click();
			Util.sleep(2000);
			System.out.println("Clicked on Next Page Button");
			Util.sleep(2000);
			System.out.println("Click on Previous Page Button");
			Util.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(elementPreviousPage)).click();
			Util.sleep(2000);
			System.out.println("Clicked on Previous Page Button");
			Util.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-header-cell[contains(text(),'Name')]/../descendant::div[contains(@class,'no')]"))).click();
			Util.sleep(2000);
			System.out.println("Selected all check box");
			Util.sleep(2000);
			UI.verifyPass("To verify all the selected checkbox ", "All checkboxes for the contacts are selected", "All checkboxes for the contacts are selected");
			Util.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-header-cell[contains(text(),'Name')]/../descendant::div[contains(@class,'no')]"))).click();
			Util.sleep(2000);
			System.out.println("DeSelected all check box");
			Util.sleep(2000);
			UI.verifyPass("To verify all the unselected checkbox ", "All checkboxes for the contacts are unselected", "All checkboxes for the contacts are unselected");
			Util.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(elementAdd)).click();
			System.out.println("Clicked on Add Button");
			Util.sleep(3000);
		}
	}
	
	public void sortingSearchFromAllTabs(String tcName) {
		if (tcName.equals("Verificationofotheroperations")) {
		Util.sleep(2000);
		System.out.println("Clicking on ToRecipient text");
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementToRecipients)).click();
		Util.sleep(2000);
		System.out.println("Clicked on ToRecipient text");
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementSenderContacts)).click();
		Util.sleep(2000);
		System.out.println("Searching contact from Sender Contacts");
		Util.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys("reshmah@opentext.com");
		Util.sleep(2000);
		System.out.println("Searched contact from Sender Contacts");
		Util.sleep(2000);
		UI.verifyPass("To verify the search text", "Searched contact is displayed", "Searched contact is displayed");
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-header-cell[contains(text(),'Name')]/../following-sibling::mat-row/mat-cell[contains(text(),' HOLLA, ')]/../descendant::div[contains(@class,'no')]"))).click();
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementSelectedRecepients)).click();
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-cell[contains(text(),' reshmah@opentext.com ')]/following-sibling::mat-cell/img"))).click();
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementAdd)).click();
		System.out.println("Clicked on Add Button");
		Util.sleep(3000);
		}
	}

	public void clickSendButton(String tcName) {
		Util.sleep(3000);
		System.out.println("Clicking on Send button");
		Util.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(elementSend)).click();
		Util.sleep(2000);
		System.out.println("Clicked on Send button");
		if(tcName.equals("VerificationofFailedStatus")) {
			UI.verifyPass("To verify Valid Transaction ID Message", " Notification Sent ",
					"Sucess!");
			new WebDriverWait(UI.getdriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Close']"))).click();
		}else if (tcName.equals("VerificationforDeliveredStatus")) {
			UI.verifyPass("To verify Valid Transaction ID Message", " Notification Sent ",
					"Sucess!");
			new WebDriverWait(UI.getdriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Close']"))).click();
		}else if(tcName.equals("VerificationForReadyForPickUp")) {
			UI.verifyPass("To verify Valid Transaction ID Message", " Notification Sent ",
					"Sucess!");
			new WebDriverWait(UI.getdriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Close']"))).click();
		}else if (tcName.equals("VerificationForProcessingStatus")) {
			UI.verifyPass("To verify Valid Transaction ID Message", " Notification Sent ",
					"Sucess!");
			new WebDriverWait(UI.getdriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Close']"))).click();
		}else if (tcName.equals("VerificationForCompletedStatus")) {
			UI.verifyPass("To verify Valid Transaction ID Message", " Notification Sent ",
					"Sucess!");
			new WebDriverWait(UI.getdriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Close']"))).click();
		}else if (tcName.equals("VerificationForBestMatchRule")) {
			UI.verifyPass("To verify Valid Transaction ID Message", " Notification Sent ",
					"Sucess!");
			new WebDriverWait(UI.getdriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Close']"))).click();
		}
		else {
			UI.verifyPass("To verify To field Message when no contacts are provided", " 'To' field should not be empty! ", " 'To' field should not be empty! ");
			new WebDriverWait(UI.getdriver(), 10)
			.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Close']"))).click();
		}
	}
	
	public void clickLogout() {
		System.out.println("Clicking on  logout button");
		Util.sleep(5000);
		UI.refresh();
		Util.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(elementLogoutButton));
		Util.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@role='button']"))).click();
		Util.sleep(4000);
		System.out.println("Scrolling to the element");
		Actions actions = new Actions(UI.getdriver());
		actions.moveToElement(elementLogoutButton).perform();
		Util.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),' Logout')]"))).click();
		Util.sleep(3000);
		UI.verifyExists_ByXPATH("//div[contains(text(),'You have been logged out.')]");
		Util.sleep(3000);
		System.out.println("Logged out Successfully");
		Util.sleep(3000);
	}

}