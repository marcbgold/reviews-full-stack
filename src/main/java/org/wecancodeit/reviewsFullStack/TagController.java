package org.wecancodeit.reviewsFullStack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TagController {

	@Resource
	TagRepository tagRepo;

	@RequestMapping("/tags")
	public String showAllCategories(Model model) {
		model.addAttribute("tagListing", tagRepo.findAll());
		return "allTags";
	}

	@RequestMapping("/tag")
	public String showTag(@RequestParam(value = "tagId", required = true) Long id, Model model) {
		model.addAttribute("currentTag", tagRepo.findOne(id));
		return "singleTag";
	}
}
