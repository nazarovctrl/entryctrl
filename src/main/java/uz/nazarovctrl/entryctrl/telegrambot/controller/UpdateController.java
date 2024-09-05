package uz.nazarovctrl.entryctrl.telegrambot.controller;

import uz.nazarovctrl.entryctrl.i18n.MessageCode;
import uz.nazarovctrl.entryctrl.service.TelegramUserService;
import uz.nazarovctrl.entryctrl.telegrambot.exp.TelegramBotException;
import uz.nazarovctrl.entryctrl.telegrambot.service.TelegramBotExceptionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import io.github.nazarovctrl.telegrambotspring.context.UserContext;
import io.github.nazarovctrl.telegrambotspring.controller.AbstractUpdateController;

@RequiredArgsConstructor
@Component
public class UpdateController extends AbstractUpdateController {
    private final MessageController messageController;
    private final TelegramBotExceptionService exceptionService;
    private final TelegramUserService telegramUserService;

    @Override
    public void handle(Update update) {
        try {
            telegramUserService.save(UserContext.getUser());

            if (update.hasMessage()) {
                messageController.handle(update.getMessage());
            } else {
                throw new TelegramBotException(MessageCode.TELEGRAMBOT_UNSUPPORTED_MESSAGE);
            }
        } catch (TelegramBotException e) {
            exceptionService.sendResponse(e.getCode());
        }
    }
}
