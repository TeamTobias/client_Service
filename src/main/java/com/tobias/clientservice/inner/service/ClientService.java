package com.tobias.clientservice.inner.service;

import com.tobias.clientservice.inner.domain.Client;
import com.tobias.clientservice.inner.domain.RequestClient;

import java.util.List;

public interface ClientService {
    void addClient(RequestClient client);
    Iterable<Client> getClientsAll();
    void deleteClient(int id);
    void setClient(int clientId, RequestClient client);
}
