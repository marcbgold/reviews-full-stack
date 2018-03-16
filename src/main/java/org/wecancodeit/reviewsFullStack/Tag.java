package org.wecancodeit.reviewsFullStack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;

	@ManyToMany(mappedBy = "tags")
	private Collection<Review> reviews;

	@SuppressWarnings("unused")
	private Tag() {
	}

	public Tag(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	public String getTagSize() {
		if (reviews.size() < 2) {
			return "small-tag";
		}

		if (reviews.size() < 3) {
			return "medium-tag";
		}

		return "large-tag";

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

		return id == ((Tag) obj).id;
	}
}
