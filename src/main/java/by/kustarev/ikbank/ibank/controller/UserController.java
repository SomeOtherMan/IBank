package by.kustarev.ikbank.ibank.controller;

import by.kustarev.ikbank.ibank.model.Dimension;
import by.kustarev.ikbank.ibank.model.User;
import by.kustarev.ikbank.ibank.service.DimensionService;
import by.kustarev.ikbank.ibank.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final DimensionService dimensionService;
    private List<Dimension> roles, clients;

    @Autowired
    public UserController(UserService userService, DimensionService dimensionService) {
        this.userService = userService;
        this.dimensionService = dimensionService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        log.info("IN getAllUsers users: {}", users);

        return "user";
    }

    @GetMapping("/create")
    public String createForm(Model model, User user) {
        roles = dimensionService.getDimensionsByTypeCode("ROLE");
        clients = dimensionService.getDimensionsByTypeCode("CLIENT");

        log.info("IN createUserForm roles: {} and clients: {}", roles, clients);

        model.addAttribute("roles", roles);
        model.addAttribute("clients", clients);

        return "user-create";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        roles = dimensionService.getDimensionsByTypeCode("ROLE");
        clients = dimensionService.getDimensionsByTypeCode("CLIENT");
        User user = userService.findById(id);

        log.info("IN createUserForm roles: {} and clients: {} and user: {}", roles, clients, user);

        model.addAttribute("roles", roles);
        model.addAttribute("clients", clients);
        model.addAttribute("user", user);

        return "user-update";
    }

    @PostMapping("/create")
    public String save(User user) {
        log.info("User before saving {}", user);

        user.setCreatedOn(new Date(System.currentTimeMillis()));
        user.setIsActive(true);
        userService.saveUser(user);

        log.info("User with id {} has been saved", user.getId());

        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);

        log.info("IN deleteUser user with id {} has been deleted", id);

        return "redirect:/user";
    }

}
