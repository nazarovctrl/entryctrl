package uz.nazarovctrl.entryctrl.telegrambot.exp;

import lombok.Getter;

@Getter
public class TelegramBotException extends Exception {
    private final String code;

    public TelegramBotException(String code) {
        this.code = code;
    }
}
