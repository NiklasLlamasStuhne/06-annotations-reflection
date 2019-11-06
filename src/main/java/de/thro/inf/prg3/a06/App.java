package de.thro.inf.prg3.a06;

import com.google.gson.Gson;
import de.thro.inf.prg3.a06.model.Joke;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {



	public static void main(String[] args) {



		Gson gson = new Gson();
		Joke j = gson.fromJson("{\"id\": 0, \"joke\": \"Haha.\", \"rubric\": [\"flachwitz\",\"schwarzer Humor\"]}", Joke.class);

		String s = gson.toJson(j);

		System.out.println(s);

		// TODO fetch a random joke and print it to STDOUT
	}

}
