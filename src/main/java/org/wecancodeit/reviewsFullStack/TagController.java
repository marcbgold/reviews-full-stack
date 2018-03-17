package org.wecancodeit.reviewsFullStack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TagController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	@RequestMapping("/tags")
	public String showAllCategories(Model model) {
		model.addAttribute("tagListing", tagRepo.findAll());
		return "allTags";
	}

	@RequestMapping("/tag/{id}")
	public String showTag(@PathVariable Long id, Model model) {
		model.addAttribute("currentTag", tagRepo.findOne(id));
		return "singleTag";
	}

	@RequestMapping("/review/{reviewId}/tag/{tagId}/deletetag")
	public String deleteTagFromReview(@PathVariable Long reviewId, @PathVariable Long tagId) {
		Review review = reviewRepo.findOne(reviewId);
		Tag tag = tagRepo.findOne(tagId);
		review.removeTag(tag);

		reviewRepo.save(review);
		return ("singleReview :: tag-list");
	}
}
