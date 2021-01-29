package com.opentext.businessnetwork.BNSUI.tests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opentext.bn.core.Datatable;
import com.opentext.bn.core.UI;
import com.opentext.businessnetwork.BNSUI.TestBase;

public class BNSUIScenarios extends TestBase {

	public String testName;

	@BeforeMethod
	public void getTestName(Method method) {
		testName = method.getName();
	}

	public BNSUIScenarios() {
		// System.err.println("Test class invoked");
		// wait = new WebDriverWait(UI.getdriver(), 10);
	}

	@Test(dataProvider = "error_transactionid")
	public void testErrortransactionId(String tcname, String transactionID) {
		UI.setTCName(tcname);
		pages().bnsuiLogin().dologin(BNSUIURL,BNSUserName,BNSPassword);
		pages().bnsuiOperation().enteringTransactionID(transactionID);
		pages().bnsuiOperation().selectingRecipients(tcname);
		pages().bnsuiOperation().clickSendButton(tcname);
		pages().bnsuiOperation().clickLogout();
	}

	@Test(dataProvider = "valid_transactionid")
	public void testValidTransactionid(String tcname, String transactionID) {
		UI.setTCName(tcname);
		//login
		pages().bnsuiLogin().dologin(BNSUIURL,BNSUserName,BNSPassword);
		pages().bnsuiOperation().enteringTransactionID(transactionID);
		pages().bnsuiOperation().checkboxFunction(tcname);
		pages().bnsuiOperation().sortingSearchFromAllTabs(tcname);
		pages().bnsuiOperation().clickSendButton(tcname);
		pages().bnsuiOperation().clickLogout();
	}

	@DataProvider(name = "valid_transactionid")
	public Object[][] testvalidtransactionidDataProvider() {
		List<String[]> list = new ArrayList<String[]>();
		String currentDirectory = System.getProperty("user.dir");
		String testConfigurationFilePath = currentDirectory + "\\" + "testdata" + "\\" + "TransactionID.xlsx";
		Datatable dt = new Datatable(testConfigurationFilePath, "Valid_TransactionID");
		int columnCount = dt.columnCount();
		int rowCount = dt.rowCount();
		for (int row = 1; row <= rowCount; row++) {
			String[] str = new String[columnCount - 2];
			if (dt.getCellValue(row, 2).equalsIgnoreCase("Yes")) {
				for (int col = 3; col <= columnCount; col++) {
					str[col - 3] = dt.getCellValue(row, col);
				}
				list.add(str);
			}
		}
		String[][] data = new String[list.size()][];
		list.toArray(data);
		return data;
	}

	@DataProvider(name = "error_transactionid")
	public Object[][] testerrortransactionidDataProvider() {
		List<String[]> list = new ArrayList<String[]>();
		String currentDirectory = System.getProperty("user.dir");
		String testConfigurationFilePath = currentDirectory + "\\" + "testdata" + "\\" + "TransactionID.xlsx";
		Datatable dt = new Datatable(testConfigurationFilePath, "Error_TransactionID");
		int columnCount = dt.columnCount();
		int rowCount = dt.rowCount();
		for (int row = 1; row <= rowCount; row++) {
			String[] str = new String[columnCount - 2];
			if (dt.getCellValue(row, 2).equalsIgnoreCase("Yes")) {
				for (int col = 3; col <= columnCount; col++) {
					str[col - 3] = dt.getCellValue(row, col);
				}
				list.add(str);
			}
		}
		String[][] data = new String[list.size()][];
		list.toArray(data);
		return data;
	}
}