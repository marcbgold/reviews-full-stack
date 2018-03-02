package org.wecancodeit.reviews;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Review {

	private long id;
	private String title;
	private Date reviewDate;
	private int yearPublished;
	private String category;
	private String description;
	private String imageUrl;
	private Collection<String> content;
	private Collection<String> tags = new ArrayList<>();

	public Review(long id, String title, Date reviewDate, int yearPublished, String category, String description, String imageUrl, String haikuFirstLine, String haikuSecondLine,
			String haikuThirdLine, String... tagInput) {
		this.id = id;
		this.title = title;
		this.reviewDate = reviewDate;
		this.yearPublished = yearPublished;
		this.category = category;
		this.description = description;
		this.imageUrl = imageUrl;
		this.content = new ArrayList<String>(asList(haikuFirstLine, haikuSecondLine, haikuThirdLine));
		for (String current : tagInput) {
			this.tags.add(current);
		}
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

	public String getCategory() {
		return category;
	}

	public Collection<String> getContent() {
		return content;
	}

	public Collection<String> getTags() {
		return tags;
	}

}
