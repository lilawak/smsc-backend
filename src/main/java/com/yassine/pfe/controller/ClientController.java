package com.yassine.pfe.controller;

import com.yassine.pfe.entity.Client;
import com.yassine.pfe.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController                         // C'est un controller REST
@RequestMapping("/api/clients")         // Toutes les URLs commencent par /api/clients
@CrossOrigin(origins = "*")             // Autorise Angular à appeler cette API
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    // GET /api/clients → liste de tous les clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id,
                                               @RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateClient(id, client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
