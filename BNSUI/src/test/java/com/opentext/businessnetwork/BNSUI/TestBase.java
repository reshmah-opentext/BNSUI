package com.opentext.businessnetwork.BNSUI;

import java.util.Properties;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.opentext.bn.core.Config;
import com.opentext.bn.core.FirstLayer;
import com.opentext.bn.file.FileUtility;

public class TestBase extends FirstLayer {
	
	public static Properties TESTCONFIG;
    public static String BNSURL;
    public static String BNSUIURL;
    public static String BNSUserName;
    public static String BNSPassword;

	  @BeforeSuite
	    public void setTestEnvironment() {
	        Config.setFF64();
	        Config.setTeamName("PEREGRINE");
	        Config.setToEmails("OT_ScrumTeam_Peregrine@opentext.com");
	        Config.setCustomTestSuiteName("BNS UI Regression Scenarios");
	        
	    }
	
	@BeforeTest
    public void testInitialize() {
        TESTCONFIG = FileUtility.getPropertiesFile("testdata/app.properties");
        BNSUIURL = TESTCONFIG.getProperty("portal");
        BNSUserName = TESTCONFIG.getProperty("loginusername");
        BNSPassword = TESTCONFIG.getProperty("loginpassword");

    }
	public PageBase pages() {
		return new PageBase();
	}
}
