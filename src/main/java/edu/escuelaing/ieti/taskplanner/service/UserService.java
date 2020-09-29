package edu.escuelaing.ieti.taskplanner.service;

import edu.escuelaing.ieti.taskplanner.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(String userId);

    User create(User user);

    User update(User user) throws Exception;

    void remove(String userId);
}
