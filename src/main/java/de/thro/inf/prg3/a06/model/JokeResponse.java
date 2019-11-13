package de.thro.inf.prg3.a06.model;

import com.google.gson.annotations.SerializedName;

public class JokeResponse {

	@SerializedName("type")
	private String type;

	@SerializedName("value")
	public Joke value;



}
