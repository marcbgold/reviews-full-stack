package org.wecancodeit.reviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewsController {

	@Resource
	ReviewRepository repository;

	@RequestMapping("/review")
	public String showReview(@RequestParam(value = "reviewId", required = true) Long id, Model model) {
		model.addAttribute("currentReview", repository.getReviewByID(id));
		return "review";
	}

	@RequestMapping("/review-listing")
	public String showAllReviews(Model model) {
		model.addAttribute("reviewListing", repository.getAllReviews());
		return "reviews";

	}

}
