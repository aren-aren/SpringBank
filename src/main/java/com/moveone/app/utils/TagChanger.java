package com.moveone.app.utils;

public class TagChanger {
	public static String tagChange(String str) {
		 return str.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
