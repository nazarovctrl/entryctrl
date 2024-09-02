package uz.nazarovctrl.entryctrl;

import io.github.nazarovctrl.telegrambotspring.annotation.EnableTelegramLongPollingBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableTelegramLongPollingBot
@SpringBootApplication
public class EntryctrlApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntryctrlApplication.class, args);
    }

}
