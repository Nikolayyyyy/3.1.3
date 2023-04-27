package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

@Component
public class TableInserter implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public TableInserter(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) {
        User user1 =new User("Andrey","Andreyev",25,"abc","a");
        User user2 =new User("Alex","Alexeev",33,"bcd","a");
        User user3 = new User("Viktor","Viktorov",45,"cde","a");
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");

        roleService.addRole(user);
        roleService.addRole(admin);

        user1.addRole(user);
        user2.addRole(admin);
        user3.addRole(user);
        user3.addRole(admin);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

    }
}
