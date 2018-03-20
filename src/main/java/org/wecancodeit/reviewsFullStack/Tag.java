package org.wecancodeit.reviewsFullStack;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;

	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private Set<Review> reviews;

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

	@JsonIgnore
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
