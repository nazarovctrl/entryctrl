package uz.nazarovctrl.entryctrl.telegrambot;

import uz.nazarovctrl.entryctrl.exp.TelegramBotException;
import uz.nazarovctrl.entryctrl.i18n.MessageInternalizationService;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class MessageController {
    private final MessageInternalizationService internalizationService;

    public MessageController(MessageInternalizationService internalizationService) {
        this.internalizationService = internalizationService;
    }

    public void handle(Message message) throws TelegramBotException {
        if (!message.hasText()) {
            throw new TelegramBotException(internalizationService.getMessage("telegrambot.unsupported.message", "ru"));
        }
    }
}
