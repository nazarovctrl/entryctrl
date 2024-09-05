package uz.nazarovctrl.entryctrl.telegrambot.service;

import uz.nazarovctrl.entryctrl.i18n.MessageCode;
import uz.nazarovctrl.entryctrl.telegrambot.MessageService;
import uz.nazarovctrl.entryctrl.i18n.MessageInternalizationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import io.github.nazarovctrl.telegrambotspring.context.UserContext;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class TextService {
    private final MessageService messageService;
    private final MessageInternalizationService internalizationService;

    public void replyStart() {
        User user = UserContext.getUser();
        String message = internalizationService.getMessage(MessageCode.TELEGRAMBOT_REPLY_START, user.getLanguageCode());

        KeyboardButton projectsButton = new KeyboardButton(internalizationService.getMessage(MessageCode.TELEGRAMBOT_MENU_PROJECTS, user.getLanguageCode()));
        KeyboardButton cabinetButton = new KeyboardButton(internalizationService.getMessage(MessageCode.TELEGRAMBOT_MENU_CABINET, user.getLanguageCode()));

        KeyboardRow row = new KeyboardRow();
        row.add(projectsButton);
        row.add(cabinetButton);

        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(keyboard);
        markup.setResizeKeyboard(true);

        SendMessage sendMessage = new SendMessage(String.valueOf(user.getId()), message);
        sendMessage.setReplyMarkup(markup);

        messageService.sendMessage(sendMessage);
    }

    public void openProjects() {
        messageService.sendMessage(UserContext.getUser().getId(), "Projects menu opened");
    }

    public void openCabinet() {
        messageService.sendMessage(UserContext.getUser().getId(), "Cabinet menu opened");
    }
}
