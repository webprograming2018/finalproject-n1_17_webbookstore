package com.fsoft.minhla1.utils;

import java.io.File;

public class FileHelper {
	public static final String RELATIVE_URL="./WebContent/views/res/img/";
	
	public void copy(File source,String destination) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("./file.xml").getFile());
	}
}
