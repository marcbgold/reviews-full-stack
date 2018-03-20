package org.wecancodeit.reviewsFullStack;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;

	@JsonIgnore
	@ManyToOne
	private Category category;
	private String title;
	private Date reviewDate;
	private int yearPublished;

	@Lob
	private String description;
	private String imageUrl;

	// @JsonIgnore
	@Lob
	@ElementCollection
	private Collection<String> content;

	@JsonIgnore
	@ManyToMany
	private Set<Tag> tags;

	@JsonIgnore
	@OneToMany(mappedBy = "review")
	private Collection<Comment> comments;

	@SuppressWarnings("unused")
	private Review() {
	}

	public Review(Category category, String title, Date reviewDate, int yearPublished, String description, String imageUrl, String haikuFirstLine, String haikuSecondLine,
			String haikuThirdLine, Tag... tags) {
		this.category = category;
		this.title = title;
		this.reviewDate = reviewDate;
		this.yearPublished = yearPublished;
		this.description = description;
		this.imageUrl = imageUrl;
		this.content = new ArrayList<String>(asList(haikuFirstLine, haikuSecondLine, haikuThirdLine));
		this.tags = new HashSet<>(Arrays.asList(tags));
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

	public Collection<Tag> getTags() {
		return tags;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public String addTag(Tag tag) {
		if (!(tags.contains(tag))) {
			tags.add(tag);
			return "added";
		} else {
			return "duplicate";
		}
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
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

		return id == ((Review) obj).id;
	}

}
