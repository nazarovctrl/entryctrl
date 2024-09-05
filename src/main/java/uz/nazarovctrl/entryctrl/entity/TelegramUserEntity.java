package uz.nazarovctrl.entryctrl.entity;

import uz.nazarovctrl.entryctrl.i18n.LangCode;

import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.User;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class TelegramUserEntity {
    @Id
    private Long id;
    private String firstname;
    private Boolean isBot;
    private String lastname;
    private String username;
    private LangCode langCode;
    private Boolean isPremium;

    private Boolean isActive;

    public TelegramUserEntity(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstName();
        this.isBot = user.getIsBot();
        this.lastname = user.getLastName();
        this.username = user.getUserName();
        this.langCode = LangCode.valueOf(user.getLanguageCode().toUpperCase());
        this.isPremium = user.getIsPremium();
        this.isActive = true;
    }
}
