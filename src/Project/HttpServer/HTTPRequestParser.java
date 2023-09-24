package Project.HttpServer;

import java.util.ArrayList;
import java.util.List;

public class HTTPRequestParser {
    HTTPRequest request = new HTTPRequest();
    Route route = new Route();

    /**
     * function(requestLine) {
     * arr[] = requestLine.toCharArray();
     * piecesOfRequestLine[] = getPieces(arr);
     * // httpVerb = getVerb(arr);
     * // path = getPath(arr);
     * // version = getVersion(arr); HTTP/1.1.
     * }
     */


    public HTTPRequest parseRequest(String requestLine) {

        request.httpMethod = new HTTPMethod();
        request.httpMethod.verb = "";
        request.version = new HTTPVersion();
        request.version.version = "";
        request.path = new Path();
        request.path.absolutePath = "";
        request.path.query = "";

        String[] arr = {request.httpMethod.verb, request.path.absolutePath, request.path.query, request.version.version};

        char[] requestLineAsArray = requestLine.toCharArray();

        List<Character> charList = new ArrayList<>();

        return getRequest(charList,requestLineAsArray,arr);

    }

    public HTTPRequest getRequest(List<Character> charList, char[] requestLineAsArray, String[] arr) {

        int arrPos = 0;

        for (int i = 0; i < requestLineAsArray.length; i++) {
            if (requestLineAsArray[i] == ' ' || requestLineAsArray[i] == '?') {

                for (int x = 0; x < charList.size(); x++) {
                    arr[arrPos] = arr[arrPos] + charList.get(x).toString();
                }
                arrPos++;
                charList.clear();
            } else {
                charList.add(requestLineAsArray[i]);

               // if (charList.get(i) )
            }
        }
        for (int x = 0; x < charList.size(); x++) {
            arr[arrPos] = arr[arrPos] + charList.get(x).toString();
        }
        charList.clear();

        request.httpMethod.setVerb(arr[0]);
        request.path.setAbsolutePath(arr[1]);
        request.path.setQuery(arr[2]);
        request.version.setVersion(arr[3]);


        return request;
    }

}
