package hr.ht.marin.zadatak.entitiy;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotEmpty(message = "Authorisation level must be specified")
    @Enumerated(EnumType.STRING)
    private List<AuthLevel> auth;
    
    public AppUser(@NotBlank(message = "Username cannot be blank") String username,
            @NotBlank(message = "Password cannot be blank") String password,
            @NotEmpty(message = "Authorisation level must be specified") List<AuthLevel> auth) {
        this.username = username;
        this.password = password;
        this.auth = auth;
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<AuthLevel> getAuth() {
        return auth;
    }
    public void setAuth(List<AuthLevel> auth) {
        this.auth = auth;
    }
}
