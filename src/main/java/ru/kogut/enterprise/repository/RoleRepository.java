package ru.kogut.enterprise.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kogut.enterprise.models.Role;

public interface RoleRepository extends CrudRepository<Role, String> {
}
