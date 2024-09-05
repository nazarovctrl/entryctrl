package uz.nazarovctrl.entryctrl.telegrambot.controller;

import uz.nazarovctrl.entryctrl.i18n.MessageCode;
import uz.nazarovctrl.entryctrl.telegrambot.service.TextService;
import uz.nazarovctrl.entryctrl.telegrambot.KeyboardMessageService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@RequiredArgsConstructor
@Component
public class TextController {
    private final TextService textService;
    private final KeyboardMessageService keyboardMessageService;

    public void handle(Message message) {
        String text = message.getText();
        if (text.equals("/start")) {
            textService.replyStart();
        } else {
            String messageCode = keyboardMessageService.getMessageCode(text);

            switch (messageCode) {
                case MessageCode.TELEGRAMBOT_MENU_PROJECTS -> {
                    textService.openProjects();
                    return;
                }
                case MessageCode.TELEGRAMBOT_MENU_CABINET -> {
                    textService.openCabinet();
                    return;
                }
            }

            System.out.println("Do something");
        }
    }
}
