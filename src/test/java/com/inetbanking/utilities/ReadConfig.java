package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File file=new File("./Configuration/Config.properties");
		try {
			FileInputStream fins=new FileInputStream(file);
			pro=new Properties();
			pro.load(fins);
		}
		catch(Exception ex)
		{
			System.out.println("Exception is "+ex.getMessage() );
		}
	}
	public String getApplicationURL() {
	String getUrl=pro.getProperty("baseURL");
	return getUrl;
	}
	
	public String getUserName() {
		String getUsername=pro.getProperty("username");
		return getUsername;
		}
	public String getPassword() {
		String getpassword=pro.getProperty("password");
		return getpassword;
		}
	public String getChromePath() {
		String getchrome=pro.getProperty("chromepath");
		return getchrome;
		}
	public String getFirefox() {
		String getfirefox=pro.getProperty("firefoxpath");
		return getfirefox;
		}
	public String getIE() {
		String getInternetExplorer=pro.getProperty("iepath");
		return getInternetExplorer;
		}
	
}
