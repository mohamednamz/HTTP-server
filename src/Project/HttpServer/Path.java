package Project.HttpServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Path {
    public String absolutePath;
    public String query;
    public HashMap<String, String> queryMap;

    public HashMap<String, String> paramsMap;

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setQueryMap(HashMap<String, String> queryMap) {
        this.queryMap = queryMap;
    }

    public void queryMap() {
        queryMap = new HashMap<>();

        queryMap.put("/testing", "name=Namz");
        queryMap.put("/testing", "name=Namz&age=25");
        queryMap.put("/testing", "DFSDFSDF");

    }

    public static String[] clear(String[] query) {
        Arrays.fill(query, "");
        return query;
    }


}
