package ru.kogut.enterprise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kogut.enterprise.enums.Roles;
import ru.kogut.enterprise.models.Role;
import ru.kogut.enterprise.models.User;
import ru.kogut.enterprise.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserById(String id) {
        if (id.isEmpty() || id == null) return null;
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    @Transactional
    public void deleteUserById(String id) {
        if (id.isEmpty() || id == null) return;
        User user = getUserById(id);
        if (user == null) return;
        userRepository.delete(user);
    }

    @Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void initUser(String login, String password, String userName, boolean isActive, List<Roles> roles) {
        final User user = new User(login, passwordEncoder.encode(password), userName, true);
        final ArrayList<Role> listRoles = new ArrayList<>();
        for (Roles eRoles : roles) {
            listRoles.add(new Role(user, eRoles));
        }
        user.setRoles(listRoles);
        userRepository.save(user);
    }
}
