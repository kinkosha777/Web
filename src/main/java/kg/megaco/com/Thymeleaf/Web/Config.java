package kg.megaco.com.Thymeleaf.Web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class Config {
    public Config(){
//        <tr th:each="user : ${users}">
//                <td th:next="${user.name}"></td>
//                <td th:next="${user.firstname}"></td>
//                <td th:next="${user.login}"></td>
//                <td th:next="${user.password}"></td>
//                <td th:next="${user.email}"></td>

    }
    @Bean
    public List<User> getUser(){
        return new ArrayList<>();

    }

    @Bean
    public Long getUserId(){
        return ThreadLocalRandom.current().nextLong(100L);
    }
}
