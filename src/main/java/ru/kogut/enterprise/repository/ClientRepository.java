package ru.kogut.enterprise.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kogut.enterprise.models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
}
