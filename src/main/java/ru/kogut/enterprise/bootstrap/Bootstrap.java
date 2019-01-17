package ru.kogut.enterprise.bootstrap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kogut.enterprise.enums.Roles;
import ru.kogut.enterprise.services.UserService;

import java.util.Arrays;

@Component
public class Bootstrap implements InitializingBean {

    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        userService.initUser("Admin","123", "Administrator", true, Arrays.asList(Roles.ADMIN));
        userService.initUser("User","123", "User", true, Arrays.asList(Roles.USER));
    }
}
