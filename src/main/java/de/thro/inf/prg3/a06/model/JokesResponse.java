package de.thro.inf.prg3.a06.model;

import com.google.gson.annotations.SerializedName;

public class JokesResponse {

	@SerializedName("type")
	private String type;

	@SerializedName("value")
	private Joke[] value;




}
