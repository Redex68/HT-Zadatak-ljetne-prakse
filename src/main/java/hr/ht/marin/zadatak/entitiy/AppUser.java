package hr.ht.marin.zadatak.entitiy;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class AppUser {
    @Id
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

    public AppUser() {
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


    public String authoritiesToString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(auth.get(0).toString());
        for(int i = 1; i < auth.size(); i++) {
            sBuilder.append(',');
            sBuilder.append(auth.get(i).toString());
        }

        return sBuilder.toString();
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AppUser other = (AppUser) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
}
