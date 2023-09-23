package Project.HttpServer;

import java.util.HashMap;

public class Path {
    public String absolutePath;
    public HashMap<String, String> queryMap;

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }
}
