package uz.nazarovctrl.entryctrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.nazarovctrl.telegrambotspring.annotation.EnableTelegramLongPollingBot;

@EnableTelegramLongPollingBot
@SpringBootApplication
public class EntryctrlApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntryctrlApplication.class, args);
    }
}
