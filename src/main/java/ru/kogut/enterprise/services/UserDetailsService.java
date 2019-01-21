package ru.kogut.enterprise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.view.ThymeleafView;
import ru.kogut.enterprise.models.Role;
import ru.kogut.enterprise.models.User;
import ru.kogut.enterprise.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final User user = findByLogin(userName);
        if (user == null) throw new UsernameNotFoundException("User not found");
        if (!user.isActive()) throw new SecurityException("User is not active");
        ExpressionParser parser = new SpelExpressionParser();
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(userName);
        builder.password(user.getPassword());
        final List<Role> userRoles = user.getRoles();
        final List<String> roles = new ArrayList<>();
        for (Role role:userRoles) {
            roles.add(role.toString());
        }
        builder.roles(roles.toArray(new String[]{}));
        return builder.build();
    }

    private User findByLogin(String userName){
        if (userName == null || userName.isEmpty()) return null;
        return userRepository.findByLogin(userName);
    }

}
