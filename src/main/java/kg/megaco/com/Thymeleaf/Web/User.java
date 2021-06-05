package kg.megaco.com.Thymeleaf.Web;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;




public class User {


    private Long id;
    @Pattern(regexp = "[a-zA-Z]*")
    @NotEmpty(message = "Поле Имя не должно быть пустым!")
    @Size(min=3,max = 15,message = "Поле Имя должно содержать минимально 3 символов,максимально 15")
    private String name;
    @NotEmpty(message = "Поле Email не должен быть пустым!")
    @Email(message = "Примерно как должно выглядить Email:bishkek@gmail.com")
    private String email;
    @NotEmpty(message = "Поле Пароль не должен быть пустым!")
    @Size(min = 8,message = "Поле Пароль должен быть не менее 8ми символов!")
    @Pattern(regexp = "[a-zA-Z0-9!-&]*")
    private String password;
    private boolean isActive;

    public User() {
    }

    public User(Long id, @NotEmpty(message = "Поле Имя не должно быть пустым!") @Size(min = 3, max = 15, message = "Поле Имя должно содержать минимально 3 символов,максимально 15") String name, @NotEmpty(message = "Поле Email не должен быть пустым!") @Email(message = "Примерно как должно выглядить Email:bishkek@gmail.com") String email, @NotEmpty(message = "Поле Пароль не должен быть пустым!") @Size(min = 8, message = "Поле Пароль должен быть не более 8ми символов!") String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
