package repository;

import model.User;

import java.util.List;

public interface IUserRepository {

    User save(User user);

    List<User> findAll();
}
