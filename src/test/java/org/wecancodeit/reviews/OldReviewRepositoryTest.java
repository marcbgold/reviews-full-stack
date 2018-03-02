package org.wecancodeit.reviews;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;

public class OldReviewRepositoryTest {

	OldReviewRepository underTest = new OldReviewRepository();
	Review firstReview = new Review("category", "first", new Date(), 2018, "description", "imageUrl", "content", "content", "content");
	Review secondReview = new Review("category", "second", new Date(), 2018, "description", "imageUrl", "content", "content", "content");
	Review thirdReview = new Review("category", "third", new Date(), 2018, "description", "imageUrl", "content", "content", "content");

	@Test
	public void shouldFindFirstReviewByID() {
		underTest = new OldReviewRepository(firstReview);
		Review found = underTest.getReviewByID(00001L);

		assertThat(found.getTitle(), is("first"));
	}

	@Test
	public void shouldFindSecondReviewByID() {
		underTest = new OldReviewRepository(firstReview, secondReview);
		Review found = underTest.getReviewByID(00002L);

		assertThat(found.getTitle(), is("second"));
	}

	@Test
	public void shouldFindAllReviews() {
		underTest = new OldReviewRepository(firstReview, secondReview, thirdReview);

		Collection<Review> result = underTest.getAllReviews();

		assertThat(result, containsInAnyOrder(firstReview, secondReview, thirdReview));
	}

}
