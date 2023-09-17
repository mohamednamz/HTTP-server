package Project.HttpServer;

public class HTTPRequestParser  {

    HTTPMethod method = new HTTPMethod();
    HTTPRequest request = new HTTPRequest();

    public HTTPRequest parseRequest(String requestLine) {

        String[] arr = {request.httpMethod.verb,request.path.absolutePath,request.version.version};

        int listPos = 0;
        int stringPos = 0;
        char[] requestLineAsArray = requestLine.toCharArray();

        for (int i = 0; i < requestLineAsArray.length; i++) {

            if(requestLineAsArray[i] != ' ') {
                addCharToString(arr[listPos],requestLineAsArray[i],stringPos);
                stringPos++;
            } else {
                listPos++;
                stringPos = 0;
            }
        }
        return request;
    }

    public static String addCharToString(String string, char c, int position) {
        return string.substring(0,position) + c + string.substring(position);
    }

}
