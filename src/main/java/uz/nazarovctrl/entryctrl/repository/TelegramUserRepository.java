package uz.nazarovctrl.entryctrl.repository;

import uz.nazarovctrl.entryctrl.entity.TelegramUserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUserEntity, Long> {
}
