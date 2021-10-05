package com.javamodeling.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FileUtils {

	public static final String DEFAULT_CHARSET = "MS949";

	public static final String KOR_CHARSET = "MS949"; //EUC-KR

	public static final String ENG_CHARSET = "ISO-8859-1";

	// 문제 있는 확장자가 존재할 파일일경우 -1 리턴
	public static int checkFileExt(String filename) {
		String f = "";
		String[] badext = { ".php", ".php3", ".php4", ".ph", "phtml", ".jsp", ".html", ".htm",
				".phps", ".cgi", ".exe", ".asp" };
		int dotindex = filename.lastIndexOf(".");
		if (dotindex == -1) {
			return -2; // 확장자가 존재 하지 않을 경우에는 -2를 리턴한다.
		}
		f = filename.substring(dotindex);
		for (int i = 0; i < badext.length; i++) {
			if (f.equals(badext[i])) {
				return -1; // 문제가 있는 확장자 일경우에는 -1을 리턴한다.
			}
		}
		return 1; // 문제가 없을경우에는 1을 리턴한다.
	}

	public static void deleteFile(String fileName, String uploadPath) {

		new File(uploadPath + fileName).delete();
	}

	/**
	 * 한글을 영문으로 Conversion해주는 프로그램.
	 * @param korean 영문으로 바꾸어질 한글 String
	 * @return 영문로 바꾸어진 String
	 */
	public static String K2E(String korean) {
		String english = null;

		if (korean == null) {
			return null;
		}

		try {
			english = new String(korean.getBytes(KOR_CHARSET), ENG_CHARSET);
		} catch (UnsupportedEncodingException e) {
			english = new String(korean);
		}

		return english;
	}

	public static String getJustFileName(String filePath) {

		return filePath.substring(filePath.lastIndexOf("\\") + 1);
	}

	/**
	 * 절대경로로 지정된 텍스트 파일을 읽어들인다.
	 * @param fullPathFile
	 * @return
	 */
	public static String readTextFileAbsolutePath(String fullPathFile) {

		StringBuffer buffer = new StringBuffer();

		FileReader fileReader = null;
		
		BufferedReader bufferedReader = null;
		
		try {
			
			fileReader = new FileReader(fullPathFile);
			
			bufferedReader = new BufferedReader(fileReader);
			
			char[] data = new char[1024 * 2];
			
			while (bufferedReader.read(data) != -1) {
				buffer.append(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
				}
			}
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
				}
			}
		}
		
		return buffer.toString();
		
	}
	
}
