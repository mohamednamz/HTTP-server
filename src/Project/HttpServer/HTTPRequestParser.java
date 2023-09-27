package Project.HttpServer;

import java.util.*;

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
        request.path.queryMap = new HashMap<>();

        String[] arr = {request.httpMethod.verb, request.path.absolutePath, request.path.query, request.version.version};

        char[] requestLineAsArray = requestLine.toCharArray();

        List<Character> charList = new ArrayList<>();

        return getRequest(charList, requestLineAsArray, arr);

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
            }
        }
        for (int x = 0; x < charList.size(); x++) {
            arr[arrPos] = arr[arrPos] + charList.get(x).toString();
        }
        charList.clear();

        request.httpMethod.setVerb(arr[0]);
        request.path.setAbsolutePath(arr[1]);
        request.path.setQuery(arr[2]);
        request.path.setQueryMap(request.path.query);
        request.version.setVersion(arr[3]);

        //splitQuery(request.path.query);

        return request;
    }

//    public HTTPRequest splitQuery(String queryparse) {
//
//        HTTPRequest httpRequest = new HTTPRequest();
//        httpRequest.path = new Path();
//        httpRequest.path.queryMap = new HashMap<>();
//
//        char[] queryChar = queryparse.toCharArray();
//        String key = "";
//        String value = "";
//        int arrPos = 0;
//
//        String[] query = {key, value};
//
//        List<Character> charList = new ArrayList<>();
//
//        for (int i = 0; i < queryChar.length; i++) {
//
//            if (queryChar[i] == '=' || queryChar[i] == '&') {
//                for (int x = 0; x < charList.size(); x++) {
//                    query[arrPos] = query[arrPos] + charList.get(x).toString();
//                }
//                arrPos++;
//                charList.clear();
//            } else {
//                charList.add(queryChar[i]);
//            }
//
//            if (queryChar[i] == '&') {
//                httpRequest.path.queryMap.put(query[0], query[1]);
//                clear(query);
//                arrPos = 0;
//
//            }
//        }
//        for (int x = 0; x < charList.size(); x++) {
//            query[arrPos] = query[arrPos] + charList.get(x).toString();
//        }
//        charList.clear();
//        httpRequest.path.queryMap.put(query[0], query[1]);
//
//        return httpRequest;
//
//    }

//    public static String[] clear(String[] query) {
//        Arrays.fill(query, "");
//        return query;
//    }

}
