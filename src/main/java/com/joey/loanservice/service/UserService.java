package com.joey.loanservice.service;

import com.joey.loanservice.model.UserModel;
import com.joey.loanservice.repository.UserRepository;
import com.joey.loanservice.strategy.userValidations.INewUserValidationsStrategy;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.spring.guides.loanservice.user.UserType;
import io.spring.guides.loanservice.user.UserInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final List<INewUserValidationsStrategy> newUserValidationsStrategyList;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository,
                       List<INewUserValidationsStrategy> newUserValidationsStrategyList) {
        this.userRepository = userRepository;
        this.newUserValidationsStrategyList = newUserValidationsStrategyList;
    }

    public UserType createUser (UserInfo data) {

        newUserValidationsStrategyList.forEach(validation -> validation.execute(data));

        UserModel userModel = new UserModel();
        userModel.setDocument(data.getDocument());
        userModel.setName(data.getName());
        userModel.setIncomePerYear(data.getIncomePerYear());

        String dateString = data.getDateOfBirth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date =  LocalDate.parse(dateString, formatter);
        userModel.setDateOfBirth(date);

        System.out.println(userModel);
        userModel = userRepository.save(userModel);
        UserType userType = new UserType();
        BeanUtils.copyProperties(userModel, userType);

        LOGGER.info("[:] Created: {}", userModel);
        return userType;
    }

        public Iterable<UserModel> getUser () {
        return userRepository.findAll();
    }

    public UserType getUserById (Long id) {
        UserModel userModel =  userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found user for id: " + id));
        UserType userType = new UserType();
        BeanUtils.copyProperties(userModel, userType);

        LOGGER.info("[:] Found By Id: {}", id);
        return userType;
    }

    public UserType getUserByDocument (String document) {
        UserModel userModel = userRepository.findByDocument(document)
                .orElseThrow(() -> new EntityNotFoundException("Not found user for document: " + document));
        UserType userType = new UserType();
        BeanUtils.copyProperties(userModel, userType);

        LOGGER.info("[:] Found By Document: {}", document);
        return userType;
    }

    public UserModel getUserByModelDocument (String document) {
        return userRepository.findByDocument(document)
                .orElseThrow(() -> new EntityNotFoundException("Not found user for document: " + document));
    }

    public UserType updateUser (Long newIncome, Long id) {
        UserModel userModel =  userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found user for id: " + id));
        userModel.setIncomePerYear(newIncome);
        userModel = this.userRepository.save(userModel);
        UserType userType = new UserType();
        BeanUtils.copyProperties(userModel, userType);

        LOGGER.info("[:] Updated: {}", userModel);
        return userType;
    }

    public void deleteUser (Long id) {
        this.userRepository.deleteById(id);
        LOGGER.info("[:] Deleted: {}", id);
    }
}
