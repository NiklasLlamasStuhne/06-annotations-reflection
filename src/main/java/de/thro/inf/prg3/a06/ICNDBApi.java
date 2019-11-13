package de.thro.inf.prg3.a06;

import de.thro.inf.prg3.a06.model.Joke;
import de.thro.inf.prg3.a06.model.JokeResponse;
import de.thro.inf.prg3.a06.model.JokesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public interface ICNDBApi {





	Call<List<JokeResponse>> listJokeResponse(@Path("user") String user);

	@GET("/jokes/random")
	Call<JokeResponse> getRandomJoke();

	Call<JokeResponse> getRandomJoke(String []categoriesToInclude);

	Call<JokesResponse> getRandomJokes(int count);

	Call<JokesResponse> getJokeByld(int id);




}
