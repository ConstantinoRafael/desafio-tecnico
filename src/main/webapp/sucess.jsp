<%@ page import="java.sql.Connection, infra.ConnectionFactory, repository.UserRepository, model.User, java.util.List" %>
<!DOCTYPE html>

<html lang="pt-br">

    <meta charset="UTF-8">
    <title>title</title>
<body>
    <h1>Adicionado com sucesso!</h1>

    <h1>Lista de usuarios</h1>
    <table>
    <%
        Connection connection = ConnectionFactory.getConnection();
        UserRepository userRepository = new UserRepository(connection);
        List<User> users = userRepository.findAll();

        for(User user : users) {
    %>
    <tr>
        <td><%= user.getName() %> -</td>
        <td><%= user.getEmail() %></td>
    </tr>
    <%
    }
    %>
    </table>

</body>
</html>