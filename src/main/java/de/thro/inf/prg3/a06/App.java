package de.thro.inf.prg3.a06;

import com.google.gson.Gson;
import de.thro.inf.prg3.a06.model.Joke;
import de.thro.inf.prg3.a06.model.JokeResponse;
import de.thro.inf.prg3.a06.model.JokesResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {



	public static void main(String[] args) throws IOException{



		Gson gson = new Gson();

		//Joke
		Joke j = gson.fromJson("{\"id\": 0, \"joke\": \"Haha.\", \"rubric\": [\"flachwitz\",\"schwarzer Humor\"]}", Joke.class);

		String s = gson.toJson(j);

		System.out.println("Joke"+s);

		//JokeResponse
		JokeResponse jr = gson.fromJson("{\"type\": \"success\", \"value\": " + s +"}", JokeResponse.class);
		String jrs = gson.toJson(jr);
		System.out.println("JokeResponse:"+jrs);

		//JokesResponse
		JokesResponse jsr = gson.fromJson("{\"type\": \"success\", \"value\": ["+ s +","+ s +"]}",JokesResponse.class);
		String jsrs = gson.toJson(jsr);
		System.out.println("JokesResponse:"+jsrs);



		//Retrofit
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.icndb.com")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		ICNDBApi service = retrofit.create(ICNDBApi.class);




		System.out.println(service.getRandomJoke().execute());


		// TODO fetch a random joke and print it to STDOUT
	}

}
