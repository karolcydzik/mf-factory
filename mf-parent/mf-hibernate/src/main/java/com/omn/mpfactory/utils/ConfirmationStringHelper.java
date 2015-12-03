package com.omn.mpfactory.utils;

import org.springframework.stereotype.Component;

@Component
public class ConfirmationStringHelper {
	
	private final static int PREFIX_LENGTH = 5;
	private final static int ST_LENGTH = 250;
	
	public String getConfirmationString(String nick, String email, String password){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < PREFIX_LENGTH; i++) {
			sb.append("X");
		}
		sb.append(String.format("%03d", nick.length()));
		sb.append(nick);
		sb.append(String.format("%03d", email.length()));
		sb.append(email);
		sb.append(String.format("%03d", password.length()));
		sb.append(password);
		for (int i = sb.length(); i < ST_LENGTH; i++) {
			sb.append("Y");
		}
		return sb.toString();
	}
	
	public String getNick(String conString){
		int startPoint = getNickStart(conString);
		return getCredencial(conString, startPoint);
	}
	
	public String getEmail(String conString){
		int startPoint = getEmailStart(conString);
		return getCredencial(conString, startPoint);
	}
	
	public String getPassword(String conString){
		int startPoint = getPasswordStart(conString);
		return getCredencial(conString, startPoint);
	}
	
	private String getCredencial(String conString, int startPoint){
		int startString = startPoint + 3;
		int length = Integer.parseInt(conString.substring(startPoint, startString));
		return conString.substring(startString, startString + length);
	}
	
	private int getPasswordStart(String conString){
		int emailStart = getEmailStart(conString);
		int emailLength = Integer.parseInt(conString.substring(emailStart, emailStart + 3));
		return emailStart + 3 + emailLength;
	}

	private int getEmailStart(String conString){
		int nickStart = getNickStart(conString);
		int nickLength = Integer.parseInt(conString.substring(nickStart, nickStart + 3));
		return nickStart + 3 + nickLength;
	}

	private int getNickStart(String conString){
		return PREFIX_LENGTH;
	}

}