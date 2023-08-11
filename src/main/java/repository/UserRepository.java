package repository;

import infra.ConnectionFactory;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserRepository implements IUserRepository {

    public UserRepository(Connection connection) {}

    @Override
    public User save(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?,?,?)";

        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
