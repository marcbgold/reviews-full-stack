package org.wecancodeit.reviewsFullStack;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Category category;
	private String title;
	private Date reviewDate;
	private int yearPublished;

	@Lob
	private String description;
	private String imageUrl;

	@Lob
	@ElementCollection
	private Collection<String> content;

	// @ManyToMany
	// private Collection<String> tags = new ArrayList<>();

	public Review() {
	}

	public Review(Category category, String title, Date reviewDate, int yearPublished, String description, String imageUrl, String haikuFirstLine, String haikuSecondLine,
			String haikuThirdLine) { // , String... tagInput) {
		this.category = category;
		this.title = title;
		this.reviewDate = reviewDate;
		this.yearPublished = yearPublished;
		this.description = description;
		this.imageUrl = imageUrl;
		this.content = new ArrayList<String>(asList(haikuFirstLine, haikuSecondLine, haikuThirdLine));
		// for (String current : tagInput) {
		// this.tags.add(current);
	}

	public long getId() {
		return id;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public String getTitle() {
		return title;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public String getDescription() {
		return description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Category getCategory() {
		return category;
	}

	public Collection<String> getContent() {
		return content;
	}

	// public Collection<String> getTags() {
	// return tags;
	// }

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

		return id == ((Review) obj).id;
	}

}
