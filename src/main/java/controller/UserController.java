package controller;

import http.request.HttpRequest;
import http.response.HttpResponse;
import model.db.DataBase;
import model.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String PATH = "/user";

    @Override
    protected void doPost(HttpRequest httpRequest, HttpResponse httpResponse) {
        User user = new User(
                httpRequest.getParameter("userId"),
                httpRequest.getParameter("password"),
                httpRequest.getParameter("name"),
                httpRequest.getParameter("email")
        );
        DataBase.addUser(user);
        logger.debug("save userId : {}", user.getUserId());

        httpResponse.sendRedirect("/index.html");
    }

    @Override
    protected String getPath() {
        return PATH;
    }
}
