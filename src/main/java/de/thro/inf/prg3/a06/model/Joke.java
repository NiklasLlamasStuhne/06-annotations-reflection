package de.thro.inf.prg3.a06.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.google.gson.Gson;
/**
 * @author Peter Kurfer
 * Created on 11/9/17.
 */
public final class Joke {
	@SerializedName("id")
	private int number;
	@SerializedName("joke")
	private String content;
	@SerializedName("rubric")
	private String[] rubrics;

	public int getNumber() {
		return number;
	}

	public String getContent() {
		return content;
	}

	public String[] getRubrics(){return rubrics;}

	public void setNumber(int n){
		number = n;
	}

	public void setContent(String c){
		content = c;
	}

	public void setRubrics(String [] r){
		rubrics = r;
	}





	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Joke)) return false;

		Joke joke1 = (Joke) o;

		return new EqualsBuilder()
				.append(getNumber(), joke1.getNumber())
				.append(getContent(), joke1.getContent())
				.append(rubrics, joke1.rubrics)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(getNumber())
				.append(getContent())
				.append(rubrics)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("number", number)
				.append("content", content)
				.append("rubrics", rubrics)
				.toString();
	}
}
