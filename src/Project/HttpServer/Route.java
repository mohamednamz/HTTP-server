package Project.HttpServer;

import java.util.ArrayList;
import java.util.List;

public class Route {
    public HTTPMethod httpMethod;
    public String path;
    public String[] routeList = {"GET", "POST", "PUT", "DELETE", "HEADER"};
    List<String> possibleRoutes = new ArrayList<>();

    public void possibleRoutes() {

        possibleRoutes.add("GET");
        possibleRoutes.add("POST");
        possibleRoutes.add("PUT");
        possibleRoutes.add("DELETE");
        possibleRoutes.add("HEADER");

    }

    public void initialiseRouteList() {
        possibleRoutes();
    }

    public List<String> getRouteList(char character, int position) {

        for (int i = 0; i < routeList.length; i++) {
            char[] routeInChars = routeList[i].toCharArray();

            if (routeInChars[position] != character) {
                possibleRoutes.remove(routeList[i]);
            }
        }
        return possibleRoutes;
    }
}
