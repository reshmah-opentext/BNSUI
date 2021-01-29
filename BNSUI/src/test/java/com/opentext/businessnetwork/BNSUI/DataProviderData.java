package com.opentext.businessnetwork.BNSUI;

import com.opentext.bn.core.gEnvPar;

public final class DataProviderData {
	public static final String configurationFilePath = gEnvPar.baseDir()+"\\testdata\\Configuration.ini";	
	public static final String sectionTestDocument = "TestDocument";
	public static final String sectionTPModel = "TPModel";
	public static final String sectionTPShellExecution = "TPShellExecution";
	public static final String sectionDataTracking = "DataTracking";
	public static final String filePath = gEnvPar.baseDir()+"\\testdata\\Node10-10Data_TpShell.csv";
	public static final int IMPORT_WAIT = 240;
	private DataProviderData() {
		throw new IllegalStateException("DataProvider class");
	}
}
