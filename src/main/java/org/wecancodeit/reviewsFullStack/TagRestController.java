package org.wecancodeit.reviewsFullStack;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagRestController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	@RequestMapping("/review/{reviewId}/addtag/{tagName}/{tagDescription}")
	public Tag addTagtoReview(@PathVariable Long reviewId, @PathVariable String tagName, @PathVariable String tagDescription) {
		Review review = reviewRepo.findOne(reviewId);
		Tag tag = tagRepo.findByNameIgnoreCase(tagName);

		if (tag == null) {
			tag = new Tag(tagName, tagDescription);
			tagRepo.save(tag);
		}

		String result = review.addTag(tag);
		reviewRepo.save(review);
		if (result.equals("added")) {
			return tag;
		} else {
			return null;
		}
	}

	@RequestMapping("/review/{reviewId}/tag/{tagId}/deletetag")
	public String deleteTagFromReview(@PathVariable Long reviewId, @PathVariable Long tagId) {
		Review review = reviewRepo.findOne(reviewId);
		Tag tag = tagRepo.findOne(tagId);
		review.removeTag(tag);
		reviewRepo.save(review);

		if (tag.getReviews().size() == 0) {
			tagRepo.delete(tag);
		}

		return null;
	}
}
