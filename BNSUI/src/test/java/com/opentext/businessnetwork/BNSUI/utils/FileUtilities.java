package com.opentext.businessnetwork.BNSUI.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.opentext.bn.core.UI;
import com.opentext.businessnetwork.BNSUI.DataProviderData;

public final class FileUtilities {
	
	private static Map<String, String> sectionInfo = new HashMap<String, String>();
	private static String value;
	
	private FileUtilities() {
	}

	public static String getValueFromIni(String section, String Key)
	{
	    value = getIniInstance().fetch(section, Key);
	    return value;
	}	
	
	public static Map <String, String> getSectionFromIni(String section)
	{	    
		Ini.Section sectionObj = getIniInstance().get(section);
		for (String optionKey: sectionObj.keySet()) {
            sectionInfo.put(optionKey, sectionObj.fetch(optionKey));
        }
	    return sectionInfo;
	}
	
	private static Ini getIniInstance()
	{
		Ini ini = null;
		try{
			ini = new Ini(new File(DataProviderData.configurationFilePath));
		}
		catch(InvalidFileFormatException e) {
			UI.StepFail("Error reading ini file", "Invalid file format for the file : " + DataProviderData.configurationFilePath);
		}
		catch (IOException e) {
			UI.StepFail("Error reading ini file","Invalid file : " + DataProviderData.configurationFilePath);
			  }
		return ini;		
	}
	public static void zipFiles(String filesFolder, String zipFileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(zipFileName);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
		
		File dir = new File(filesFolder);
		File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
			  for (File fileToZip : directoryListing) {
				  FileInputStream fis = new FileInputStream(fileToZip);
				  ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
				  zipOut.putNextEntry(zipEntry);
				  byte[] bytes = new byte[1024];
		            int length;
		            while((length = fis.read(bytes)) >= 0) {
		                zipOut.write(bytes, 0, length);
		            }
		            fis.close();
			  }  
        }
		zipOut.closeEntry();
		zipOut.finish();
        zipOut.close();
        fos.close();
	}
	private static String pdfExtractContent(String filePath) throws IOException {
		String pdfContent = "";
		PdfReader pdfReader = new PdfReader(filePath);
		int noOfPages = pdfReader.getNumberOfPages();
		for (int i=1;i<=noOfPages;i++) {
			String textFromPage = PdfTextExtractor.getTextFromPage(pdfReader, i);
			pdfContent = pdfContent + textFromPage;
		}
		pdfReader.close();
		return pdfContent;
		
	}
	public static boolean pdfVerifyContent(String filePath, String expectedContent) throws IOException {
		String pdfExtractContent = pdfExtractContent(filePath);
		if (pdfExtractContent.contains(expectedContent)) {
			return true;
		}else {
			return false;
		}
	}
}