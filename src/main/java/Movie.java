import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Movie {

    private final String title;
    private String director;
    private String type;
    private int year;
    private String runtime;
    private String actors;
    private String plot;

    public Movie(String title) {
        this.title = title;
        setParameters();
    }


    // zmienic zeby w setParams nie tworzyło nowego obiektu tylko do tego samego
    


    public void setParameters() {
        String response = getResponse()
                .replace("Title", "title")
                .replace("Director","director")
                .replace("Year","year")
                .replace("Genre","type")
                .replace("Runtime","runtime")
                .replace("Actors","actors")
                .replace("Plot","plot");
        Movie test = new Gson().fromJson(response, Movie.class);
    }

    public void showInfo(){
        System.out.println(this);
    }

    private String getResponse() {
        String apiKey = "21eb6951&";
        String apiPath = "http://www.omdbapi.com/?apikey=";
        String url = apiPath + apiKey + "t=" + title;
        return request(url);
    }

    private static String request(String uri) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(uri);
            getRequest.addHeader("accept", "application/json");
            HttpResponse response = httpClient.execute(getRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String result = "";
            String output;
            while ((output = br.readLine()) != null) {
                result += output;
            }
            httpClient.getConnectionManager().shutdown();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", runtime='" + runtime + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}
