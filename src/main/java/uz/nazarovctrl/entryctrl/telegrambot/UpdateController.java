package uz.nazarovctrl.entryctrl.telegrambot;

import uz.nazarovctrl.entryctrl.exp.TelegramBotException;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import io.github.nazarovctrl.telegrambotspring.context.UserContext;
import io.github.nazarovctrl.telegrambotspring.controller.AbstractUpdateController;

@Component
public class UpdateController extends AbstractUpdateController {
    private final MessageController messageController;
    private final MessageService messageService;

    public UpdateController(MessageController messageController, MessageService messageService) {
        this.messageController = messageController;
        this.messageService = messageService;
    }

    @Override
    public void handle(Update update) {
        try {
            if (update.hasMessage()) {
                messageController.handle(update.getMessage());
            }
        } catch (TelegramBotException e) {
            messageService.sendMessage(UserContext.getUser().getId(), e.getMessage());
        }
    }
}
