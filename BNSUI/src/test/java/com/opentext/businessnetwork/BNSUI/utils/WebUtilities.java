package com.opentext.businessnetwork.BNSUI.utils;

import org.openqa.selenium.JavascriptExecutor;
import com.opentext.businessnetwork.BNSUI.TestBase;

/**
 * Declare all the Web Utilities. When framework does not provide any of the web utilities
 * declare it here and move it to framework when the method can be used in the global context. 
 * 
 * @author ryoganat
 *
 */
public final class WebUtilities {

	/**
	 * Declare the private constructor for accidental call from implementer.
	 */
	private WebUtilities() {
	}

	/**
	 * Execute the javascript command.
	 * @param script
	 * @param arguments
	 * @return
	 */
	public static Object executeJavascript(String script, Object... arguments) {
		return ((JavascriptExecutor) TestBase.getdriver()).executeScript(script, arguments);
	}
}
