package com.yazon.api.service;

import com.yazon.api.entity.ClientEntity;
import com.yazon.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<ClientEntity> findAll(){
        Sort sort = Sort.by("id").descending();
        return this.clientRepository.findAll(sort);
    }
    public ClientEntity findOneById (Long id) throws Exception {
        Optional<ClientEntity> clientExist = this.clientRepository.findById(id);

        if(clientExist.isPresent()){
            return clientExist.get();
        }

        throw new Exception("Client not found");
    }
    public ClientEntity create(ClientEntity client){
        return this.clientRepository.save(client);
    }

}
