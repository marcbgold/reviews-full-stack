package org.wecancodeit.reviewsFullStack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	@Resource
	ReviewRepository reviewRepo;

	@RequestMapping("/review/{id}")
	public String showReview(@PathVariable Long id, Model model) {
		model.addAttribute("currentReview", reviewRepo.findOne(id));
		return "singleReview";
	}
}
