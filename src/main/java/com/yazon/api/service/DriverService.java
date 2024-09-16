package com.yazon.api.service;


import com.yazon.api.entity.ClientEntity;
import com.yazon.api.entity.DriverEntity;
import com.yazon.api.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<DriverEntity> findAll(){
        Sort sort = Sort.by("id").descending();
        return this.driverRepository.findAll(sort);
    }
    public DriverEntity findOneById (Long id) throws Exception {
        Optional<DriverEntity> driver = this.driverRepository.findById(id);

        if(driver.isPresent()){
            return driver.get();
        }

        throw new Exception("Driver not found");
    }
    public DriverEntity create(DriverEntity d){
        return this.driverRepository.save(d);
    }
}
