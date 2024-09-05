package uz.nazarovctrl.entryctrl.telegrambot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

public class ButtonService {
    public ReplyKeyboardMarkup getMarkup() {
        new KeyboardButton();

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        return markup;
    }
}
