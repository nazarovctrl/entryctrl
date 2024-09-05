package uz.nazarovctrl.entryctrl.telegrambot.service;

import uz.nazarovctrl.entryctrl.telegrambot.MessageService;
import uz.nazarovctrl.entryctrl.i18n.MessageInternalizationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;
import io.github.nazarovctrl.telegrambotspring.context.UserContext;

@RequiredArgsConstructor
@Service
public class TelegramBotExceptionService {
    private final MessageService messageService;
    private final MessageInternalizationService internalizationService;

    public void sendResponse(String messageCode) {
        User user = UserContext.getUser();
        String message = internalizationService.getMessage(messageCode, user.getLanguageCode());

        messageService.sendMessage(user.getId(), message);
    }
}
