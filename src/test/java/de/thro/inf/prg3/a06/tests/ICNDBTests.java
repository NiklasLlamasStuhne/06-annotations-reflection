package de.thro.inf.prg3.a06.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.thro.inf.prg3.a06.ICNDBApi;
import de.thro.inf.prg3.a06.model.Joke;
import de.thro.inf.prg3.a06.model.JokeResponse;
import de.thro.inf.prg3.a06.model.JokesResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
class ICNDBTests {

	private static final Logger logger = LogManager.getLogger(ICNDBTests.class);
	private static final int REQUEST_COUNT = 100;

	@Test
	void testCollision() throws IOException {
		Set<Integer> jokeNumbers = new HashSet<>();
		int requests = 0;
		boolean collision = false;
		ICNDBApi icndbApi;

		while (requests++ < REQUEST_COUNT) {
			// TODO Prepare call object
			Gson gson = new Gson();

			// TODO Perform a synchronous request
			Retrofit retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create(gson))
				.baseUrl("http://api.icndb.com")
				.build();
			// TODO Extract object
			icndbApi = retrofit.create(ICNDBApi.class);
			Joke j = icndbApi.getRandomJoke().execute().body().value;

			if(jokeNumbers.contains(j.getNumber())) {
				logger.info(String.format("Collision at joke %s", j.getNumber()));
				collision = true;
				break;
			}

			jokeNumbers.add(j.getNumber());
			logger.info(j.toString());
		}

		assertTrue(collision, String.format("Completed %d requests without collision; consider increasing REQUEST_COUNT", requests));
	}
}
