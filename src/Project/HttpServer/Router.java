package Project.HttpServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Router {
    List<Route> routeList = new ArrayList<>();

    public Route matchRoute(HTTPMethod httpMethod, String path) {

        Route httpRequest = new Route();
        httpRequest.httpMethod = httpMethod;
        httpRequest.path = path;

        for (int i = 0; i < routeList.size(); i++) {
            if (Objects.equals(routeList.get(i).httpMethod, httpRequest.httpMethod) && Objects.equals(routeList.get(i).path, httpRequest.path)) {
                return httpRequest;
            }
        }
        // From the request line -- create the HTTPRequest object
        // From the HTTPRequest object you can manipulate the routes

        return null;
    }

    public void addRoute(String httpMethod, String path) {

        Route httpRequest = new Route();

        httpRequest.httpMethod.verb = httpMethod;
        httpRequest.path = path;

        routeList.add(httpRequest);

    }
}
