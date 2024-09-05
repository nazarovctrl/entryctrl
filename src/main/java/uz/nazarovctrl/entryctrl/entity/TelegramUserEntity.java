package uz.nazarovctrl.entryctrl.entity;

import lombok.Setter;

import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.User;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
public class TelegramUserEntity {
    @Id
    private Long id;
    private String firstname;
    private Boolean isBot;
    private String lastname;
    private String username;
    private String langCode;
    private Boolean isPremium;

    private Boolean isActive;

    public TelegramUserEntity(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstName();
        this.isBot = user.getIsBot();
        this.lastname = user.getLastName();
        this.username = user.getUserName();
        this.langCode = user.getLanguageCode();
        this.isPremium = user.getIsPremium();
        this.isActive = true;
    }
}
