package com.tobias.clientservice.outer.rest.web;

import com.tobias.clientservice.inner.domain.Client;
import com.tobias.clientservice.inner.domain.RequestClient;
import com.tobias.clientservice.inner.domain.ResponseClient;
import com.tobias.clientservice.inner.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/health_check")
    public String status(){
            return "It's Working in Client CUD Service";
        }

    @PostMapping("/client/v1")
    public HttpStatus addProduct(@RequestBody RequestClient requestProduct) {
        clientService.addClient(requestProduct);
        return HttpStatus.OK;
    }

    @GetMapping("/client/v1")
    public ResponseEntity<List<ResponseClient>> allClient() {
        Iterable<Client> products = clientService.getClientsAll();
        List<ResponseClient> result = new ArrayList<>();
        products.forEach(v -> result.add(new ModelMapper().map(v, ResponseClient.class)));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @DeleteMapping("/client/v1/{clientId}")
    public HttpStatus deleteClient(@PathVariable("clientId") int clientId){
        clientService.deleteClient(clientId);
        return HttpStatus.OK;
    }

    @PutMapping("/client/v1/{clientId}")
    public HttpStatus setClient(@PathVariable("clientId") int clientId,@RequestBody RequestClient requestProduct){
        clientService.setClient(clientId, requestProduct);
        return HttpStatus.OK;
    }
}
