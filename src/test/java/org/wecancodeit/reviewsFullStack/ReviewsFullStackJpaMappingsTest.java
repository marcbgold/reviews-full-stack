package org.wecancodeit.reviewsFullStack;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewsFullStackJpaMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;

	// @Resource
	// private TagRepository tagRepo;

	private static final Date REVIEW_DATE = new Date();
	private static final int YEAR_PUBLISHED = 2018;
	private static final String DESCRIPTION = "description";
	private static final String IMAGE_URL = "image url";
	private static final String HAIKU_FIRST_LINE = "haiku first line";
	private static final String HAIKU_SECOND_LINE = "haiku second line";
	private static final String HAIKU_THIRD_LINE = "haiku third line";

	Review firstReview;
	Review secondReview;
	Category category;

	@Before
	public void setup() {
		category = new Category("category", "description");
		firstReview = new Review(category, "first review", REVIEW_DATE, YEAR_PUBLISHED, DESCRIPTION, IMAGE_URL, HAIKU_FIRST_LINE, HAIKU_SECOND_LINE, HAIKU_THIRD_LINE);
		secondReview = new Review(category, "second review", REVIEW_DATE, YEAR_PUBLISHED, DESCRIPTION, IMAGE_URL, HAIKU_FIRST_LINE, HAIKU_SECOND_LINE, HAIKU_THIRD_LINE);
	}

	@Test
	public void shouldSaveAndLoadReview() {
		category = categoryRepo.save(category);
		firstReview = reviewRepo.save(firstReview);
		long reviewId = firstReview.getId();

		entityManager.flush();
		entityManager.clear();

		firstReview = reviewRepo.findOne(reviewId);
		assertThat(firstReview.getTitle(), is("first review"));
	}

	@Test
	public void shouldEstablishCategoryToReviewRelationship() {
		category = categoryRepo.save(category);
		long categoryId = category.getId();

		firstReview = reviewRepo.save(firstReview);
		secondReview = reviewRepo.save(secondReview);

		entityManager.flush();
		entityManager.clear();

		category = categoryRepo.findOne(categoryId);
		assertThat(category.getReviews(), containsInAnyOrder(firstReview, secondReview));
	}

	// @Test
	// public void shouldSaveAndLoadAuthor() {
	// Author underTest = authorRepo.save(new Author("first", "last"));
	// long AuthorId = underTest.getId();
	//
	// entityManager.flush();
	// entityManager.clear();
	//
	// underTest = authorRepo.findOne(AuthorId);
	// assertThat(underTest.getFirstName(), is("first"));
	// }
	//
	// @Test
	// public void shouldEstablishAuthorsToBooksRelationship() {
	// Genre genre = genreRepo.save(new Genre("test"));
	// Author firstAuthor = authorRepo.save(new Author("first", "last"));
	// Author secondAuthor = authorRepo.save(new Author("first", "last"));
	// Book book = bookRepo.save(new Book(genre, "Java", firstAuthor,
	// secondAuthor));
	// long bookId = book.getId();
	//
	// entityManager.flush();
	// entityManager.clear();
	//
	// book = bookRepo.findOne(bookId);
	// assertThat(book.getAuthors(), containsInAnyOrder(firstAuthor, secondAuthor));
	// }
	//
	// @Test
	// public void shouldEstablishBooksToAuthorsRelationship() {
	// Genre genre = genreRepo.save(new Genre("test"));
	// Author author = authorRepo.save(new Author("first", "last"));
	// Book firstBook = bookRepo.save(new Book(genre, "Java", author));
	// Book secondBook = bookRepo.save(new Book(genre, "Ruby", author));
	// long authorId = author.getId();
	//
	// entityManager.flush();
	// entityManager.clear();
	//
	// author = authorRepo.findOne(authorId);
	// assertThat(author.getBooks(), containsInAnyOrder(firstBook, secondBook));
	// }
}
