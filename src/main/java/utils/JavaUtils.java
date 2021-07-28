package utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtils {

	public static String randomNumber() {
		Random random=new Random();
		int randomNumber=random.nextInt(1000);
		String id =Integer.toString(randomNumber);
		
		return id;
		
	}

	public static String randomString() {
		String randomString=RandomStringUtils.randomAlphabetic(5);
		
		return randomString;
		
	}
}
