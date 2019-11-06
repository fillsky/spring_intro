package pl.honestit.spring.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.honestit.spring.demo.model.domain.User;
import pl.honestit.spring.demo.model.repositories.UserRepository;

@Slf4j
@Controller
@RequestMapping("/register")

public class RegistrationController {
    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String prepareRegistrationPage() {

        return "/WEB-INF/views/register-form.jsp";
    }

    @PostMapping
    public String processRegistrationPage(String username,
                                          String password,
                                          String firstName,
                                          String lastName) {

        User user = User.builder()
                .username(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName).build();
        // TODO
        userRepository.save(user);

        log.info("Zapisano użytkownika: " + user.toString());
        return "redirect:/index.html";
    }
}