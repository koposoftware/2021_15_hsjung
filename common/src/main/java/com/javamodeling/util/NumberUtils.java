package com.javamodeling.util;

import java.text.DecimalFormat;
import java.util.Random;

public class NumberUtils {

	/**
	 * 1000 단위의 킬로값으로 나눈 문자열을 얻는다.
	 * @param value
	 * @return
	 */
	public static String divideKiloByte(long value) {
		return (new Long(Math.round((value / 100.0) / 10.0))).toString();
	}

	public static String divideKiloByte(float value) {
		return (new Float(Math.round((value / 100.0) / 10.0))).toString();
	}

	public static String divideKiloByte(int value) {
		return (new Float(Math.round((value / 100.0) / 10.0))).toString();
	}

	/**
	 * 숫자를 1000 단위로 숫자에 컴마를 넣어서 리턴한다.
	 * @param num
	 * @return
	 */
	public static String convertComma(String num) {

		  int inValues = Integer.parseInt(num);
		  DecimalFormat Commas = new DecimalFormat("#,###");
		  String result_int = (String)Commas.format(inValues);
		  return result_int;
	}
	
	/**
	 * 숫자를 1000 단위로 숫자에 컴마를 넣어서 리턴한다.
	 * @param num
	 * @return
	 */
	public static String convertComma(int num) {

		  DecimalFormat Commas = new DecimalFormat("#,###");
		  String result_int = (String)Commas.format(num);
		  return result_int;
	}
	
	/**
	 * 숫자를 1000 단위로 숫자에 컴마를 넣어서 리턴한다.
	 * @param num
	 * @return
	 */
	public static String convertComma(long num) {

		  DecimalFormat Commas = new DecimalFormat("#,###");
		  String result_int = (String)Commas.format(num);
		  return result_int;
	}
	
	/**
	 * 숫자를 1000 단위로 숫자에 컴마를 넣어서 리턴한다.
	 * @param num
	 * @return
	 */
	public static String convertComma(double num) {

		  DecimalFormat Commas = new DecimalFormat("#,###");
		  String result_int = (String)Commas.format(num);
		  return result_int;
	}

	/**
	 * 숫자를 1000 단위로 숫자에 컴마와 단위를 넣어서 리턴한다.
	 * @param num 숫자
	 * @param currency 단위
	 * @return
	 */
	public static String convertCommaCurrency(String num, String currency) {

		  String result = convertComma(num) + currency;

		  return result;
	}
	
	/**
	 * 4 자리 숫자로 인증코드를 랜덤으로 생성
	 * @return
	 */
	public static String generateVerificationCode() {

		String code = String.format("%04d", new Random().nextInt(10000));

		return code;
	}
	
	/**
	 * 숫자만으로 된 전화번호를 전화번호 형식(010-1234-1234)로 변환해줌
	 * @param mobileNo (01012341234 형태)
	 * @return 010-1234-1234 형식 번호
	 */
	public static String convertMobileNo(String mobileNo) {
		
		return convertMobileNo(mobileNo, "-");
	}
	
	/**
	 * 숫자만으로 된 전화번호를  구분자를 넣어서 변환해 줌
	 * @param mobileNo (01012341234) 형식의 데이터
	 * @param delimiter 구분자
	 * @return
	 */
	public static String convertMobileNo(String mobileNo, String delimiter) {
		
		if (mobileNo == null || mobileNo.length() < 10) {
			return "";
		}
		
		String text = mobileNo.substring(0, 3) + delimiter + 
				mobileNo.substring(3, mobileNo.length()- 4) + 
				delimiter + mobileNo.substring(mobileNo.length() - 4);
		
		return text;
	}
	
	/**
	 * Color 의 HEX 코드를 ARGB 코드로 변환해서 리턴한다.
	 * @param hexARGB : #AARRGGBB 또는 #RRGGBB
	 * @return int[] 배열: [a, r, g, b]
	 */
	public static int[] convertColorHextToRGB(String hexARGB) {
		
		if (!hexARGB.startsWith("#") || !(hexARGB.length() == 7 || hexARGB.length() == 9)) {

	        throw new IllegalArgumentException("Hex color string is incorrect!");
	    }

	    int[] intARGB = new int[4];

	    if (hexARGB.length() == 9) {
	    	
	        intARGB[0] = Integer.valueOf(hexARGB.substring(1, 3), 16); // alpha
	        intARGB[1] = Integer.valueOf(hexARGB.substring(3, 5), 16); // red
	        intARGB[2] = Integer.valueOf(hexARGB.substring(5, 7), 16); // green
	        intARGB[3] = Integer.valueOf(hexARGB.substring(7), 16); // blue
	    } 
	    else {
	    	
	    	convertColorHextToRGB("#FF" + hexARGB.substring(1));
	    
	    }

	    return intARGB;
	}
}
