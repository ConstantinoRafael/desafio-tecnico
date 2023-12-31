package controller;


import infra.ConnectionFactory;
import model.User;
import repository.UserRepository;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;


public class UserController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showForm(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processForm(request,response);
    }

    private void processForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(name);
        System.out.println(email);
        System.out.println(password);

        User user = new User(name, email, password);
        Connection connection = ConnectionFactory.getConnection();
        UserRepository userRepository = new UserRepository(connection);
        userRepository.save(user);


        request.getRequestDispatcher("/sucess.jsp").forward(request, response);

    }

}

