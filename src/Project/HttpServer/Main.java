package Project.HttpServer;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Router router = new Router();

        router.addRoute("GET", "/test");
        router.addRoute("GET", "/testing?DFSDFSDF");
        router.addRoute("POST", "/testing");

        HTTPRequestParser httpRequestParser = new HTTPRequestParser();

        String requestLine = "GET /testing?DFSDFSDF HTTP/1.1";
        HTTPRequest request = httpRequestParser.parseRequest(requestLine);

        Route route = router.matchRoute(request.httpMethod, request.path.absolutePath, request.version);

        boolean doesQueryMatch = router.matchQuery(request.path.absolutePath, request.path.query);

        HTTPRequest request2 = httpRequestParser.parseRequest("GET /testing?name=Namz HTTP/1.1");

        Route route2 = router.matchRoute(request.httpMethod, request.path.absolutePath, request.version);

        HTTPRequest request3 = httpRequestParser.parseRequest("GET /testing?name=Namz&age=25 HTTP/1.1");

        HashMap<String, String> map = request3.path.queryMap; // Check this query map


        Route route5 = new Route();

        route5.initialiseRouteList();
        route5.getRouteList('G',0);
    }


}
