package uz.nazarovctrl.entryctrl.i18n;

import org.springframework.stereotype.Service;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Service
public class MessageInternalizationService {
    private final ResourceBundleMessageSource messageSource;

    public MessageInternalizationService(ResourceBundleMessageSource resourceBundleMessageSource) {
        this.messageSource = resourceBundleMessageSource;
    }

    public String getMessage(String code, String lang) {
        return messageSource.getMessage(code, null, new Locale(lang));
    }

    public String getMessage(String code, String lang, Object... arg) {
        return messageSource.getMessage(code, arg, new Locale(lang));
    }
}