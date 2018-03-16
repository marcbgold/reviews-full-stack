package org.wecancodeit.reviewsFullStack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@RequestMapping("/")
	public String showAllCategories(Model model) {
		model.addAttribute("categoryListing", categoryRepo.findAll());
		return "allCategories";
	}

	@RequestMapping("/category/{id}")
	public String showOneCategory(@PathVariable Long id, Model model) {
		Category category = categoryRepo.findOne(id);
		model.addAttribute("currentCategory", category);
		model.addAttribute("reviewListing", category.getReviews());
		return "singleCategory";
	}
}
