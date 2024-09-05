package uz.nazarovctrl.entryctrl.telegrambot;

import uz.nazarovctrl.entryctrl.i18n.LangCode;
import uz.nazarovctrl.entryctrl.i18n.MessageCode;
import uz.nazarovctrl.entryctrl.i18n.MessageInternalizationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class KeyboardMessageService {
    private HashMap<String, List<String>> replyKeyboardMessages;
    private final MessageInternalizationService internalizationService;

    public String getMessageCode(String replyKeyboardMessage) {
        for (Map.Entry<String, List<String>> entry : replyKeyboardMessages.entrySet()) {
            for (String message : entry.getValue()) {
                if (message.equals(replyKeyboardMessage)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public void init() {
        replyKeyboardMessages = new HashMap<>();
        replyKeyboardMessages.put(MessageCode.TELEGRAMBOT_MENU_PROJECTS, getMessages(MessageCode.TELEGRAMBOT_MENU_PROJECTS));
        replyKeyboardMessages.put(MessageCode.TELEGRAMBOT_MENU_CABINET, getMessages(MessageCode.TELEGRAMBOT_MENU_CABINET));

        getMessages(MessageCode.TELEGRAMBOT_UNSUPPORTED_MESSAGE);
    }

    public List<String> getMessages(String messageCode) {
        List<String> messages = new ArrayList<>();
        for (LangCode langCode : LangCode.values()) {
            messages.add(internalizationService.getMessage(messageCode, langCode.name()));
        }
        return messages;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return _ -> init();
    }
}
