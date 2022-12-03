package com.tobias.clientservice.inner.repository;

import com.tobias.clientservice.inner.domain.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findById(int id);
    void deleteById(int id);
}
