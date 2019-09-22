package http.controller;

import db.DataBase;
import http.HttpResponse;
import http.request.HttpRequest;
import model.UserFactory;

public class CreateUserController extends AbstractController {
    @Override
    public void doGet(HttpRequest request, HttpResponse response) {
        addUser(request, response);
    }

    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        addUser(request, response);
    }

    private void addUser(HttpRequest request, HttpResponse response) {
        DataBase.addUser(UserFactory.createUser(request));
        response.sendRedirect("/index.html");
    }
}