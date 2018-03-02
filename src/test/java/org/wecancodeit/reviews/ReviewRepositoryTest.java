package org.wecancodeit.reviews;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;

public class ReviewRepositoryTest {

	ReviewRepository underTest = new ReviewRepository();
	Review firstReview = new Review(00001L, "first", new Date(), 2018, "category", "description", "imageUrl", "content", "content", "content");
	Review secondReview = new Review(00002L, "second", new Date(), 2018, "category", "description", "imageUrl", "content", "content", "content");
	Review thirdReview = new Review(00003L, "third", new Date(), 2018, "category", "description", "imageUrl", "content", "content", "content");

	@Test
	public void shouldFindFirstReviewByID() {
		underTest = new ReviewRepository(firstReview);
		Review found = underTest.getReviewByID(00001L);

		assertThat(found.getTitle(), is("first"));
	}

	@Test
	public void shouldFindSecondReviewByID() {
		underTest = new ReviewRepository(firstReview, secondReview);
		Review found = underTest.getReviewByID(00002L);

		assertThat(found.getTitle(), is("second"));
	}

	@Test
	public void shouldFindAllReviews() {
		underTest = new ReviewRepository(firstReview, secondReview, thirdReview);

		Collection<Review> result = underTest.getAllReviews();

		assertThat(result, containsInAnyOrder(firstReview, secondReview, thirdReview));
	}

}
