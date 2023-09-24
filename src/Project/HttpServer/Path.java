package Project.HttpServer;

import java.util.HashMap;

public class Path {
    public String absolutePath;
    public String query;
    public HashMap<String, String> queryMap;

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void queryMap() {

        queryMap = new HashMap<>();

        queryMap.put("/testing","name=Namz");
        queryMap.put("/testing","name=Namz&age=25");
        queryMap.put("/testing","DFSDFSDF");



    }




}
