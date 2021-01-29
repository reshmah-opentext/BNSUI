package com.opentext.businessnetwork.BNSUI;

import com.opentext.businessnetwork.BNSUI.login.BNSUILogin;
import com.opentext.businessnetwork.BNSUI.tests.BNSUIOperation;

/**
 * Collection of all page instances. Abstract and Encapsulate the elements of the respective 
 * pages. When the implementer design a test cases, don't expose the objects instead offer a 
 * method with wrapped actions. 
 * 
 *
 */
public class PageBase {
	
	public BNSUILogin bnsuiLogin() {
		return new BNSUILogin();
	}
	public BNSUIOperation bnsuiOperation() {
		return new BNSUIOperation();
	}
}