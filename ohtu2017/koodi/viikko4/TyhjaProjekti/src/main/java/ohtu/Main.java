package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "013027630";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        int sumExercises = 0;
        int sumTime = 0;
        
        System.out.println("opiskelijanumero: " + subs[0].getStudent_number());

        for (Submission submission : subs) {
            sumExercises += submission.getDone();
            sumTime += submission.getHours();
            System.out.println(submission);
        }
        
        System.out.println("\nyhteensä: " + sumExercises + " tehtävää " + sumTime + " tuntia");

    }
}
