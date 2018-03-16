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

	@Resource
	CommentRepository commentRepo;

	@RequestMapping("/review/{id}")
	public String showReview(@PathVariable Long id, Model model) {
		model.addAttribute("currentReview", reviewRepo.findOne(id));
		return "singleReview";
	}

	@RequestMapping("/review/{id}/addcomment")
	public String addCommentToReview(@PathVariable Long id, String posterName, String commentText) {
		Review currentReview = reviewRepo.findOne(id);
		Comment comment = new Comment(currentReview, posterName, commentText);
		commentRepo.save(comment);

		currentReview.addComment(comment);
		reviewRepo.save(currentReview);

		System.out.println(comment.getPosterName());
		return "redirect:/review/{id}";
	}

	@RequestMapping("/review/{id}/deletecomment")
	public String deleteComment(@PathVariable Long id, Long commentId) {
		commentRepo.delete(commentId);
		return "redirect:/review/{id}";
	}

}
