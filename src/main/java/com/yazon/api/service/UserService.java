package com.yazon.api.service;

import com.yazon.api.entity.UserEntity;
import com.yazon.api.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity create(UserEntity user){
        UserEntity result = this.userRepository.save(user);

        return result;
    }

    public List<UserEntity> findAll(){
        return this.userRepository.findAll();
    }

    public Optional<UserEntity> authenticate(String login, String password) throws Exception {
        Optional<UserEntity> userExist = this.userRepository.findByLogin(login);

        if(userExist.isEmpty()){
            throw new Exception("Usuário não existe");
        }

        if(!userExist.get().getPassword().equals(password)){
            throw new Exception("Senha incorreta");
        }

        return userExist;
    }
}
