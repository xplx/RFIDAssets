package com.daoben.rfid.utils;

import org.springframework.stereotype.Service;

@Service
public class ToStringSixteen {

	public String SixHextoString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		// return "0x" + str;// 0x表示十六进制
		return str + "000000";// 0x表示十六进制
	}

	// 转换十六进制编码为字符串
	public String StringtoSixHex(String s) {
		if ("0x".equals(s.substring(0, 2))) {
			s = s.substring(2);
		}
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	public String ByteToStriong(byte[] bytes) {
		char[] alpha = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		StringBuilder strBuilder = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {
			strBuilder.append(alpha[b >>> 4 & 0xf]).append(alpha[b & 0xf]);
		}
		return strBuilder.toString();
	}

	public String HexStringToTwobinary(String hexString) {
		if (hexString == null || hexString.length() % 2 != 0)
			return null;
		String bString = "", tmp;
		for (int i = 0; i < hexString.length(); i++) {
			tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
			bString += tmp.substring(tmp.length() - 4);
		}
		return bString;
	}

	public static void main(String[] args) throws Exception {
		ToStringSixteen toStringSixteen = new ToStringSixteen();
		System.out.println(toStringSixteen.SixHextoString("92340400"));
		System.out.println(toStringSixteen.StringtoSixHex("9234"));
		System.out.println(toStringSixteen.HexStringToTwobinary("04"));
		System.out.println(Integer.parseInt("9234", 16));

	}
}
