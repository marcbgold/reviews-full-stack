package org.wecancodeit.reviews;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;
	private String categoryName;

	@OneToMany(mappedBy = "category")
	Collection<Review> reviews;

	public Category() {
	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Collection<Review> getReviews() {
		return reviews;
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

		return id == ((Category) obj).id;
	}

}
