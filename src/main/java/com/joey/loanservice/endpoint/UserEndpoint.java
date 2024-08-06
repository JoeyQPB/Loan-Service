package com.joey.loanservice.endpoint;

import com.joey.loanservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import io.spring.guides.loanservice.user.*;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/loanservice/user";

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddUserRequest")
    @ResponsePayload
    public AddUserResponse addUser (@RequestPayload AddUserRequest request) {
        UserType user = this.userService.createUser(request.getUserData());

        AddUserResponse response = new AddUserResponse();
        response.setUserData(user);
        response.setStatus("User added successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserRequest")
    @ResponsePayload
    public GetUserResponse getUser (@RequestPayload GetUserRequest request) {
        UserType user = this.userService.getUserById(request.getId());

        GetUserResponse response = new GetUserResponse();
        response.setUserData(user);
        response.setStatus(user != null ? "User found" : "User not found");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserByDocumentRequest")
    @ResponsePayload
    public GetUserResponse getUserByDoc (@RequestPayload GetUserByDocumentRequest request) {
        UserType user = this.userService.getUserByDocument(request.getDocument());

        GetUserResponse response = new GetUserResponse();
        response.setUserData(user);
        response.setStatus(user != null ? "User found" : "User not found");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        UserType user = userService.updateUser
                (request.getUserData().getIncomePerYear(),request.getUserData().getId());

        UpdateUserResponse response = new UpdateUserResponse();
        response.setUserData(user);
        response.setStatus("User updated successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        this.userService.deleteUser(request.getId());

        DeleteUserResponse response = new DeleteUserResponse();
        response.setStatus("User { " + request.getId() + " } deleted successfully");
        return response;
    }
}
