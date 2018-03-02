package org.wecancodeit.reviewsFullStack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@RequestMapping("/categories")
	public String showAllCategories(Model model) {
		model.addAttribute("categoryListing", categoryRepo.findAll());
		return "allCategories";
	}

	@RequestMapping("/category")
	public String showOneCategory(@RequestParam(value = "categoryId", required = true) Long id, Model model) {
		Category category = categoryRepo.findOne(id);
		model.addAttribute("currentCategory", category);
		model.addAttribute("reviewListing", category.getReviews());
		return "singleCategory";
	}
}
