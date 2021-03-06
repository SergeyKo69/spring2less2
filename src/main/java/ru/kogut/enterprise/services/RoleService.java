package ru.kogut.enterprise.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kogut.enterprise.models.Role;
import ru.kogut.enterprise.repository.RoleRepository;

import java.util.Optional;

public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    public Role getRoleById(String id) {
        if (id.isEmpty() || id == null) return null;
        Optional<Role> roles = roleRepository.findById(id);
        if (roles.orElse(null) == null) return null;
        return roles.get();
    }

    public void updateRole(Role role) {
        saveRole(role);
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }
}
