package Project.HttpServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Router {
    List<Route> routeList = new ArrayList<>();

    public Route matchRoute(HTTPMethod httpMethod, String path, HTTPVersion version) {

        Route httpRequest = new Route();
        httpRequest.httpMethod = httpMethod;
        httpRequest.path = path;

        if (Objects.equals(version.version, "HTTP/1.1")) {

            for (int i = 0; i < routeList.size(); i++) {
                if (Objects.equals(routeList.get(i).httpMethod.verb, httpRequest.httpMethod.verb)) {
                    for (int x = 0; x < routeList.size(); x++) {
                        if (Objects.equals(routeList.get(x).path, httpRequest.path)) {
                            return httpRequest;
                        }
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public boolean matchQuery(String path, String query) {
        Path searchQuery = new Path();
        searchQuery.queryMap();

        for (int i = 0; i < searchQuery.queryMap.size(); i++) {

            if (Objects.equals(searchQuery.queryMap.get("/testing"), query)) {
                return true;
            }
        }
        return false;

    }


    public void addRoute(String httpMethod, String path) {

        Route httpRequest = new Route();
        httpRequest.httpMethod = new HTTPMethod();


        httpRequest.httpMethod.verb = httpMethod;
        httpRequest.path = path;

        routeList.add(httpRequest);

    }
}
