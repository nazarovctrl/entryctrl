package uz.nazarovctrl.entryctrl.telegrambot.controller;

import uz.nazarovctrl.entryctrl.i18n.MessageCode;
import uz.nazarovctrl.entryctrl.telegrambot.exp.TelegramBotException;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class MessageController {
    private final TextController textController;

    public MessageController(TextController textController) {
        this.textController = textController;
    }

    public void handle(Message message) throws TelegramBotException {
        if (message.hasText()) {
            textController.handle(message);
        } else {
            throw new TelegramBotException(MessageCode.TELEGRAMBOT_UNSUPPORTED_MESSAGE);
        }
    }
}
