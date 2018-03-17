package org.wecancodeit.reviewsFullStack;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagRestController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	// @RequestMapping("/review/{reviewId}/tag/{tagId}/deletetag")
	// public Review deleteTagFromReview(@PathVariable Long reviewId, @PathVariable
	// Long tagId) {
	// Review review = reviewRepo.findOne(reviewId);
	// Tag tag = tagRepo.findOne(tagId);
	// review.removeTag(tag);
	//
	// reviewRepo.save(review);
	// return review;
	// }
}
