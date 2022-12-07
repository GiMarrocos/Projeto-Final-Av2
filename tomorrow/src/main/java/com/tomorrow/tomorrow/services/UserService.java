package com.tomorrow.tomorrow.services;

import com.tomorrow.tomorrow.entities.User;
import com.tomorrow.tomorrow.entities.util.FormatDataInput;
import com.tomorrow.tomorrow.repositories.UserRepository;
import com.tomorrow.tomorrow.services.authentication.UserValidation;
import com.tomorrow.tomorrow.services.authentication.exceptions.ExistingUserLoginException;
import com.tomorrow.tomorrow.services.authentication.exceptions.InactiveUserException;
import com.tomorrow.tomorrow.services.authentication.exceptions.IncorrectLoginOrPasswordException;
import com.tomorrow.tomorrow.services.exceptions.DatabaseException;
import org.hibernate.JDBCException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends FormatDataInput implements UserValidation {

    @Autowired
    private UserRepository repository;

    @Override
    public User loginAuthentication(String login, String password) {
        User user = repository.findByLoginAndPassword(login, password);
        if(user == null){throw new IncorrectLoginOrPasswordException("Invalid login or password");}
        else if(user.getLogin().equals(login) && user.getPassword().equals(password)){
            if (user.getStatus().equals('A')){
                user = repository.getReferenceById(user.getId());
            }else{
                throw new InactiveUserException("User is not active");
            }
        }
        return user;
    }

    public User create(User user){
        List<User> users = repository.findAll();
        for (User users_id: users) {
            if (users_id.getLogin().equals(user.getLogin())){
                throw new ExistingUserLoginException("Login already exists");
            }
        }
        user.setRegistrationDate(DATE_FORMAT());
        return repository.save(user);
    }

    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException
                ("User not found! Id: " + id, "Cause type: " + User.class.getName()));
    }

    public void delete(Long id){
        try{
            repository.delete(findById(id));
        }catch (EmptyResultDataAccessException error01){
            throw new ObjectNotFoundException("User not found! Id: " + id, "Cause type: " + User.class.getName());
        }catch (DataIntegrityViolationException error02){
            throw new DatabaseException(error02.getMessage());
        }
    }

    public void update(User usuario){
        User newUser = repository.getReferenceById(usuario.getId());
        newUser = updateData(newUser, usuario);
        repository.save(newUser);
    }

    private User updateData(User newData, User usuario) {
        newData.setStatus(usuario.getStatus());
        return newData;
    }
}
