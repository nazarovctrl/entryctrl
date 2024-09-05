package uz.nazarovctrl.entryctrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.nazarovctrl.entryctrl.entity.TelegramUserEntity;

public interface TelegramUserRepository extends JpaRepository<TelegramUserEntity, Long> {
}
