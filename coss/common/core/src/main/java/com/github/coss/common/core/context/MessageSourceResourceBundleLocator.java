package com.github.coss.common.core.context;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;

/**
 * 将ResourceBundleLocator代理为spring的MessageSource
 */
public class MessageSourceResourceBundleLocator {
    private MessageSource messageSource;

    public MessageSourceResourceBundleLocator() {
    }

    public MessageSourceResourceBundleLocator(MessageSource messageSource) {
        setMessageSource(messageSource);
    }

    public void setMessageSource(MessageSource messageSource) {
        if (messageSource == null)
            throw new IllegalArgumentException("'messageSource' must be not null");
        this.messageSource = messageSource;
    }

    public ResourceBundle getResourceBundle(Locale locale) {
        return new MessageSourceResourceBundle(messageSource, locale);
    }

}
