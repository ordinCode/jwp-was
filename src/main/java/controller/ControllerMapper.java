package controller;

import http.request.HttpRequest;

import java.util.HashMap;
import java.util.Map;

public class ControllerMapper {
    private final Map<String, Controller> controllers = new HashMap<>();

    private ControllerMapper() {
    }

    public static ControllerMapper getInstance() {
        return Holder.INSTANCE;
    }

    public void addController(AbstractController controller) {
        controllers.put(controller.getPath(), controller);
    }

    public Controller map(HttpRequest httpRequest) {
        return controllers.get(httpRequest.getPath());
    }

    public boolean isApi(HttpRequest httpRequest) {
        return controllers.containsKey(httpRequest.getPath());
    }

    private static class Holder {
        private static final ControllerMapper INSTANCE = new ControllerMapper();
    }
}
