package kr.or.ddit.utils;

import java.util.Locale;

import org.springframework.context.support.MessageSourceAccessor;

public class MessageUtils {
	
	private MessageSourceAccessor msgAccessor;
	
	public MessageUtils(MessageSourceAccessor msgAccessor) {
		this.msgAccessor = msgAccessor;
	}

	public String getMessage(String key) {
		return msgAccessor.getMessage(key);
	}
	
	public String getMessage(String key, Locale locale) {
		return msgAccessor.getMessage(key, locale);
	}
	
}
