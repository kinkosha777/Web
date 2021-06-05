package kg.megaco.com.Thymeleaf.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@Controller
@SessionAttributes("user ")
public class UserController {
    @Autowired
    private List<User> userList;
    @Autowired
    private Long userId;

    public UserController() {
    }

    @GetMapping({"/index"})
    public String showUserList( Model model) {
        model.addAttribute("users", this.userList);
        return "index";
    }

    @GetMapping({"/signup"})
    public String showSignUpForm( User user) {
        return "add-user";
    }

    @PostMapping({"/adduser"})
    public String addUser(@Valid User user, BindingResult result, Model model) {
        System.out.println(result.hasErrors());
        if (result.hasErrors()) {
            return "add-user";
        } else {
            System.out.println("new user: "+user);
            user.setId(this.userId++);
            user.setActive(true);
            this.userList.add(user);
            System.out.println(user);

            return "redirect:/index";
        }
    }

    @GetMapping({"/edit/{user}"})
    public String showUpdateForm(@PathVariable("user") long id,@Valid Model model) {
        User user = new User();
//        System.out.println(isActive);
        for (User item : userList) {
            if (item.getId() == id) {

                user = item;

                System.out.println("edit "+user);
            }
        }
        model.addAttribute("user",user);
        return "update-user";
    }

    @PostMapping({"/update/{id}"})
    public String updateUser(@PathVariable("id") long id,@Valid User user, BindingResult result, Model model) {
        boolean isActive = true;
        if (result.hasErrors()) {
            return "update-user";

        } else {
            User user1 = (User)this.userList.stream().filter((u) -> {
                return u.getId() == id;
            }).findFirst().get();
            this.userList.remove(user1);
            this.userList.add(user);

            model.addAttribute("isActive", isActive);
            return "redirect:/index";
        }
    }

    @GetMapping({"/delete/{id}"})
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = (User)this.userList.stream().filter((u) -> {
            return u.getId() == id;
        }).findFirst().get();
        this.userList.remove(user);
        return "redirect:/index";
    }

}