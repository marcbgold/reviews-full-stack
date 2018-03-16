package org.wecancodeit.reviewsFullStack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Review review;
	private String posterName;
	private String text;

	@SuppressWarnings("unused")
	private Comment() {
	}

	public Comment(Review review, String posterName, String text) {
		this.review = review;
		this.posterName = posterName;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public Review getReview() {
		return review;
	}

	public String getName() {
		return posterName;
	}

	public String getText() {
		return text;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		return id == ((Comment) obj).id;
	}

}
