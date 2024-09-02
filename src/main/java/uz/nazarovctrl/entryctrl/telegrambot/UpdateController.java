package uz.nazarovctrl.entryctrl.telegrambot;

import io.github.nazarovctrl.telegrambotspring.controller.AbstractUpdateController;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class UpdateController extends AbstractUpdateController {

    @Override
    public void handle(Update update) {

    }
}
