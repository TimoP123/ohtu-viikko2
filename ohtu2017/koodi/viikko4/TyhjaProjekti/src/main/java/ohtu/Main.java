package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "111111111111";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();
        String courseUrl = "https://ohtustats2017.herokuapp.com/courses/1.json";
        String courseBodyText = Request.Get(courseUrl).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course course = mapper.fromJson(courseBodyText, Course.class);

        int sumExercises = 0;
        int sumTime = 0;
        
        System.out.println("Kurssi: " + course + "\n");
        System.out.println("opiskelijanumero: " + subs[0].getStudent_number() + "\n");

        for (Submission submission : subs) {
            sumExercises += submission.getDone();
            sumTime += submission.getHours();
            System.out.println(submission);
        }
        
        System.out.println("\nyhteensä: " + sumExercises + " tehtävää " + sumTime + " tuntia");

    }
}
