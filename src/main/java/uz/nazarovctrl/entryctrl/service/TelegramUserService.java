package uz.nazarovctrl.entryctrl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;
import uz.nazarovctrl.entryctrl.entity.TelegramUserEntity;
import uz.nazarovctrl.entryctrl.repository.TelegramUserRepository;

@RequiredArgsConstructor
@Service
public class TelegramUserService {

    private final TelegramUserRepository telegramUserRepository;

    public void save(User user) {
        TelegramUserEntity telegramUserEntity = new TelegramUserEntity(user);

        telegramUserRepository.save(telegramUserEntity);
    }
}
