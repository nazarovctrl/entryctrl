package uz.nazarovctrl.entryctrl.telegrambot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import io.github.nazarovctrl.telegrambotspring.bot.MessageSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageService {
    private final MessageSender messageSender;

    public MessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public Message sendMessage(SendMessage sendMessage) {
        try {
            return messageSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public Message sendMessage(String chatId, String text) {
        return sendMessage(new SendMessage(chatId, text));
    }

    public Message sendMessage(Long chatId, String text) {
        return sendMessage(chatId.toString(), text);
    }
}
