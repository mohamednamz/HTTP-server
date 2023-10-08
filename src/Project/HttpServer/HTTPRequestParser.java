package Project.HttpServer;

import java.util.*;

public class HTTPRequestParser {
//    HTTPRequest request = new HTTPRequest();
//    Route route = new Route();

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

        HTTPRequest request = new HTTPRequest();
        Route route = new Route();


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

        return getRequest(charList, requestLineAsArray, arr, request);

    }

    public HTTPRequest getRequest(List<Character> charList, char[] requestLineAsArray, String[] arr, HTTPRequest request) {
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
        request.path.setQueryMap(buildQueryMap(request.path.query, request.path.queryMap));
        request.version.setVersion(arr[3]);

        //splitQuery(request.path.query);

        return request;
    }

    public HashMap<String, String> buildQueryMap(String query, HashMap<String, String> queryMap) {

        Path path = new Path();

        char[] queryChar = query.toCharArray();
        String key = "";
        String value = "";
        int arrPos = 0;

        String[] queryArr = {key, value};

        List<Character> charList = new ArrayList<>();

        for (int i = 0; i < queryChar.length; i++) {

            if (queryChar[i] == '=' || queryChar[i] == '&') {
                for (int x = 0; x < charList.size(); x++) {
                    queryArr[arrPos] = queryArr[arrPos] + charList.get(x).toString();
                }
                arrPos++;
                charList.clear();
            } else {
                charList.add(queryChar[i]);
            }

            if (queryChar[i] == '&') {
                queryMap.put(queryArr[0], queryArr[1]);
                path.clear(queryArr);
                arrPos = 0;

            }
        }

        if (queryArr[1] != null) {
            for (int x = 0; x < charList.size(); x++) {
                queryArr[arrPos] = queryArr[arrPos] + charList.get(x).toString();
            }
            charList.clear();
            queryMap.put(queryArr[0], queryArr[1]);
        }

        return queryMap;

    }


}
