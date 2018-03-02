package org.wecancodeit.reviewsFullStack;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private ReviewRepository reviewRepo;

	// @Resource
	// private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		Category rpg = categoryRepo.save(new Category("RPG", "Pretend to be some dudes, read lots of dialogue, and go save the world or something."));
		Category platformer = categoryRepo.save(new Category("Platformer", "Jump on lots of platforms, and maybe stomp on bad guys or solve some puzzles."));

		Review chronoTrigger = reviewRepo.save(new Review(rpg, "Chrono Trigger", new Date(), 1995, "Time-hopping shenanigans.", "./images/chrono-trigger.jpg",
				"Mute, spiky-haired kid", "Saves the world from space monster", "By messing with time"));
		Review crashBandicoot = reviewRepo.save(new Review(platformer, "Crash Bandicoot", new Date(), 1996, "Rodent thing with pants vs. midget mad scientist.",
				"./images/crash-bandicoot.png", "Running towards the screen", "Falling into unseen holes", "The gamedevs hate you"));
		Review portal2 = reviewRepo.save(new Review(platformer, "Portal 2", new Date(), 2011, "Free cake.  So delicious and moist.", "./images/portal.jpg",
				"Here's the test result:", "\"You're a horrible person.\"", "See? That's what it says."));
		Review superMarioWorld = reviewRepo.save(new Review(platformer, "Super Mario World", new Date(), 1990, "Turtle boss must die. Again.", "./images/super-mario-world.jpg",
				"Fat Italian guy", "Eats shrooms and murders turtles", "Bowser never learns"));
		Review undertale = reviewRepo.save(new Review(rpg, "Undertale", new Date(), 2015, "Kill everybody... or don't.  Up to you.", "./images/undertale.jpg",
				"Here, I made you this", "Cinnamon-butterscotch pie", "Now be good, won't you?"));

		// bookRepo.save(new Book(platformer, "Head First Java", firstAuthor));
		// bookRepo.save(new Book(rpg, "Fullmetal Alchemist", firstAuthor,
		// secondAuthor));
	}

}
