package ru.kogut.enterprise.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kogut.enterprise.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByLogin(@Param("login") String login);

}
