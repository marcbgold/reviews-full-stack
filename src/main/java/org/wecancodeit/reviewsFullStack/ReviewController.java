package org.wecancodeit.reviewsFullStack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	ReviewRepository reviewRepo;

	@RequestMapping("/review")
	public String showReview(@RequestParam(value = "reviewId", required = true) Long id, Model model) {
		model.addAttribute("currentReview", reviewRepo.findOne(id));
		return "singleReview";
	}
}
