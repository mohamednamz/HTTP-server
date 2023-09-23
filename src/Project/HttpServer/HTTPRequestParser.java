package Project.HttpServer;

import java.util.ArrayList;
import java.util.List;

public class HTTPRequestParser {


    HTTPMethod method = new HTTPMethod();
    HTTPRequest request = new HTTPRequest();

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

        String[] arr = {request.httpMethod.verb, request.path.absolutePath, request.version.version};
        int arrPos = 0;

        char[] requestLineAsArray = requestLine.toCharArray();


        List<Character> charList = new ArrayList<>();

        for (int i = 0; i < requestLineAsArray.length; i++) {

            if (requestLineAsArray[i] != ' ') {
                charList.add(requestLineAsArray[i]);
            } else {
                for (int x = 0; x < charList.size(); x++) {
                    arr[arrPos] = arr[arrPos] + charList.get(x).toString();
                }
                arrPos++;
                charList.clear();
            }
            if (requestLineAsArray[i] == requestLineAsArray[requestLineAsArray.length - 1]) {
                for (int x = 0; x < charList.size(); x++) {
                    arr[arrPos] = arr[arrPos] + charList.get(x).toString();
                }
                charList.clear();
            }
        }

        request.httpMethod.setVerb(arr[0]);
        request.path.setAbsolutePath(arr[1]);
        request.version.setVersion(arr[2]);


        return request;
    }

}
