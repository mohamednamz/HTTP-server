package Project.HttpServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    public void setQueryMap(String query) {

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
                clear(queryArr);
                arrPos = 0;

            }
        }
        for (int x = 0; x < charList.size(); x++) {
            queryArr[arrPos] = queryArr[arrPos] + charList.get(x).toString();
        }
        charList.clear();
        queryMap.put(queryArr[0], queryArr[1]);



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
    public static String[] clear(String[] query) {
        Arrays.fill(query, "");
        return query;
    }




}
