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
	public Tag deleteTagFromReview(@PathVariable Long reviewId, @PathVariable String tagName, @PathVariable String tagDescription) {
		// if (!(tagRepo.findByName(tagName).equals(null))) {
		// return null;
		// }

		// TODO add duplicate tag prevention

		Tag tag = new Tag(tagName, tagDescription);
		tagRepo.save(tag);

		Review review = reviewRepo.findOne(reviewId);
		review.addTag(tag);
		reviewRepo.save(review);
		return (tag);
	}

	@RequestMapping("/review/{reviewId}/tag/{tagId}/deletetag")
	public String deleteTagFromReview(@PathVariable Long reviewId, @PathVariable Long tagId) {
		Review review = reviewRepo.findOne(reviewId);
		Tag tag = tagRepo.findOne(tagId);
		review.removeTag(tag);
		reviewRepo.save(review);
		return (null);
	}
}
