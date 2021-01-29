package com.opentext.businessnetwork.BNSUI.login;

import static com.opentext.businessnetwork.BNSUI.utils.WebUtilities.executeJavascript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.opentext.bn.core.UI;
import com.opentext.bn.core.Util;
import com.opentext.businessnetwork.BNSUI.TestBase;

public class BNSUILogin{

	@FindBy(name = "username")
	WebElement elementUserName;
	
	@FindBy(name = "password")
	WebElement elementPassword;

	@FindBy(name = "login")
	WebElement elementSignIn;
	
	public BNSUILogin() {
		PageFactory.initElements(TestBase.getdriver(), this);
	}

	/**
	 * Logging into BNS UI portal. 
	 *  
	 */
	public void dologin(String BNSUIURL,String BNSUserName,String BNSPassword) {		
		UI.openURL(BNSUIURL);
		/*System.out.println(loginDetails.get(BNSUserName));
		System.out.println(getValueFromIni(testEnvironment,loginDetails.get(BNSUserName)));*/
		UI.SetText(elementUserName,BNSUserName);
		UI.SetText(elementPassword,BNSPassword);
		executeJavascript("arguments[0].click();", elementSignIn);
		System.out.println("User logged in");
		Util.sleep(2000);
		UI.verifyExists_ByXPATH("//img[@title='logout']");
		Util.sleep(2000);
		
	}
}
