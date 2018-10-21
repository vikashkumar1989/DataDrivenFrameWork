package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String userdir=System.getProperty("user.dir");
		Properties config=new Properties();
		FileInputStream fis=new FileInputStream(userdir+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		System.out.println(config.getProperty("Browser"));
		
		fis=new FileInputStream(userdir+"\\src\\test\\resources\\properties\\OR.properties");
		config.load(fis);
		System.out.println(config.getProperty("bnkmlbt"));

	}

}
