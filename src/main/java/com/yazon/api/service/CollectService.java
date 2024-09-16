package com.yazon.api.service;

import com.yazon.api.entity.CollectEntity;
import com.yazon.api.repository.CollectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectService {

    @Autowired
    private CollectRepository collectRepository;

    public List<CollectEntity> findAll() {
        return this.collectRepository.findAll();
    }

    public Optional<CollectEntity> findOneById(Long id) {
        return this.collectRepository.findById(id);
    }

    public CollectEntity create(CollectEntity data) {
        return this.collectRepository.save(data);
    }

    public Optional<CollectEntity> isConfirm(Long id) throws Exception {
        Optional<CollectEntity> coleta = this.collectRepository.findById(id);

        if (coleta.isEmpty()) {
            throw new Exception("Collect not found");
        }

        coleta.get().setConfirm(true);
        this.collectRepository.save(coleta.get());
        return coleta;
    }

    public Optional<CollectEntity> isCancel(Long id) throws Exception {
        Optional<CollectEntity> coleta = this.collectRepository.findById(id);

        if (coleta.isEmpty()) {
            throw new Exception("Collect not found");
        }

        coleta.get().setConfirm(false);
        this.collectRepository.save(coleta.get());

        return coleta;
    }

    public Optional<CollectEntity> isComplete (Long id) throws Exception {
        Optional<CollectEntity> coleta = this.collectRepository.findById(id);

        if(coleta.isEmpty()){
            throw new Exception("Collect not found");
        }
        coleta.get().setComplete(true);
        this.collectRepository.save(coleta.get());

        return coleta;
    }

}
