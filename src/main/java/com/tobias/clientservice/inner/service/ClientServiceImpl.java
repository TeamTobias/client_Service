package com.tobias.clientservice.inner.service;

import com.tobias.clientservice.inner.domain.Client;
import com.tobias.clientservice.inner.domain.RequestClient;
import com.tobias.clientservice.inner.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public Iterable<Client> getClientsAll() {return clientRepository.findAll();}

    @Transactional
    public void addClient(RequestClient requestClient) {

        Client client = clientRepository.findById(requestClient.getId());

        if (client == null) {
            client = Client.createClient(requestClient);
            clientRepository.save(client);
        }
    }

    @Transactional
    public void deleteClient(int clientId){
        clientRepository.deleteById(clientId);
    }

    public void setClient(int clientId, RequestClient requestClient){
        Client client = clientRepository.findById(clientId);
        if(client!=null){
            client.setName(requestClient.getName());
            client.setNickname(requestClient.getNickname());
            client.setEmail(requestClient.getEmail());
            client.setGender(requestClient.getGender());
            client.setBirth(requestClient.getBirth());
            client.setPhone(requestClient.getPhone());
            clientRepository.save(client);
        }
    }
}