package com.javamodeling.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

public class StringUtils {

	public StringUtils() {
	}

    /**
     * String 문자열에서 2글자 이상의 문자열을 지우고 돌려준다.
     * @param str String 원본 문자열
     * @param remove String 지울 문자열
     * @return String
     */
    public static String removeString(String originalString, String removeString) {

        StringBuffer sb = new StringBuffer();

        //지워야할 문자열로 분리하여 배열로 리턴한다.
        String[] strArray = originalString.split(removeString);

        // 배열로 나뉜 문자열을 다시 합친다.
        for (int i = 0; i < strArray.length; i++) {
            sb.append(strArray[i]);
        }

        return sb.toString();
    }

    /**
     * 문자열에서  White Character 문자를 제거한다.
     * @param value
     * @return
     */
    public static String removeWhiteChar(String value) {
    
    	String[] whiteChar = {"\r", "\n", "\t"};

    	String strResult = value;
    	for (int i = 0; i < whiteChar.length; i++) {
			strResult = removeString(strResult, whiteChar[i]);
		}
    
    	return strResult;
    }


    public static String encodingFromIso88591ToEucKr(String value) {
    	try {
			return new String(value.getBytes("8859_1"), "EUC_KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }

    public static String encodingFromIso88591ToKsc5601(String value) {
    	try {
			return new String(value.getBytes("8859_1"), "KSC5601");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }

    public static String encodingFromUtf8ToKsc5601(String value) {
    	try {
			return new String(value.getBytes("UTF-8"), "KSC5601");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }

    public static String encodingFromUtf8ToEucKr(String value) {
    	try {
			return new String(value.getBytes("UTF-8"), "EUC-KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }

    public static String encoding(String value, String encodingType) {
    	try {
			return new String(value.getBytes("8859_1"), encodingType);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }

    public static String encoding(String value, String fromEncodingType, String toEncodingType) {
    	try {
			return new String(value.getBytes(fromEncodingType), toEncodingType);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }

    public static String urlDecoding(String value) {
    
    	try {
			return URLDecoder.decode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    
    }

    /**
     * 두자리 숫자를 입력받아서, 1자리 수 인경우(0-9까지)에는 앞에 "0"을 붙여준다.
     * @param value
     * @return
     */
    public static String makeTwoDigitString(String value) {
    
    	if (value == null || value.trim().length() == 0) {
			return "";
		}
    
    	int intValue = 0;
    
    	try {
			intValue = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return "";
		}
    
    	if (intValue < 10 && intValue >= 0) {
			return "0" + intValue;
		}
    	else {
    		return value;
    	}
    
    }

    /**
     * 두자리 숫자를 입력받아서, 1자리 수 인경우(0-9까지)에는 앞에 "0"을 붙여준다.
     * @param value
     * @return
     */
    public static String makeTwoDigitString(int value) {
    
    	return makeTwoDigitString(Integer.toString(value));
    
    }
    
    /**
     * 문자열을 UTF-16 의 Hex 코드로 변환하여 리턴해준다.
     * @param value 변환할 문자열
     * @return
     */
	public static String convertUTF16(String value) {
		
		StringBuffer buffer = new StringBuffer("");
		
		try {
			for (final byte b :value.getBytes("UTF-16")) {
				buffer.append(String.format("%1$02X", (b & 0xFF)));
			}
		} catch (Exception e) {
		}
		
		String strHex = buffer.toString(); 
		
		return strHex.substring(4);
	}
	

	//기존 문자에 해당 문자가 들어 있는지 확인하여 값을 반환한다.
	public static int indexOfIgnoreCase(final CharSequence str, final CharSequence searchStr, int startPos) {
		if (str == null || searchStr == null) {
			return -1;
		}
		if (startPos < 0) {
			startPos = 0;
		}
		final int endLimit = str.length() - searchStr.length() + 1;
		if (startPos > endLimit) {
			return -1;
		}
		if (searchStr.length() == 0) {
			return startPos;
		}
		for (int i = startPos; i < endLimit; i++) {
			if (regionMatches(str, true, i, searchStr, 0, searchStr.length())) {
				return i;
			}
		}
		return -1;
	}

	static boolean regionMatches(final CharSequence cs, final boolean ignoreCase, final int thisStart,
			final CharSequence substring, final int start, final int length)    {
		if (cs instanceof String && substring instanceof String) {
			return ((String) cs).regionMatches(ignoreCase, thisStart, (String) substring, start, length);
		} else {
			int index1 = thisStart;
			int index2 = start;
			int tmpLen = length;

			while (tmpLen-- > 0) {
				char c1 = cs.charAt(index1++);
				char c2 = substring.charAt(index2++);

				if (c1 == c2) {
					continue;
				}

				if (!ignoreCase) {
					return false;
				}

				// The same check as in String.regionMatches():
				if (Character.toUpperCase(c1) != Character.toUpperCase(c2)
						&& Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
					return false;
				}
			}

			return true;
		}
	}
	
	/**
	 * 주어진 길이 만큼 영문 대소문자/숫자를 조합하여 임의의 문자를 생성한다.
	 * @param length
	 * @return
	 */
	public static String randomString(int length) {
		
		StringBuffer temp = new StringBuffer();
		
		Random rnd = new Random();
		for (int i = 0; i < length; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		
		return temp.toString();
	}

}
