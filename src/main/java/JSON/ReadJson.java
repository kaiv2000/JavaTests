package JSON;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import java.util.List;

public class ReadJson {

    public static void main(String[] args) throws IOException {


        String JSON_SOURCE = readJsonFromUrl("https://www.shazam.com/shazam/v2/en/UA/web/-/tracks/web_chart_world").toString();


        String[] all = JSON_SOURCE.split("\"heading\":");

        List<String> list = new LinkedList<String>(Arrays.asList(all));

        list.remove(0);

        String[] array;
        for (String x : list) {
            array = x.split(":");
            String singer = array[1].split("\"")[1];
            String title = array[2].split("\"")[1];

            System.out.println(singer + " - " + title);
        }
    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
