package org.wecancodeit.reviews;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class OldReviewRepository {

	Map<Long, Review> reviewList = new HashMap<>();

	public OldReviewRepository() {
		reviewList.put(00001L, new Review("Video Game", "Chrono Trigger", new Date(), 1995, "Time-hopping shenanigans.", "./images/chrono-trigger.jpg", "Mute, spiky-haired kid",
				"Saves the world from space monster", "By messing with time", "Video Game", "SNES", "2D", "RPG"));

		reviewList.put(00002L, new Review("Video Game", "Crash Bandicoot", new Date(), 1996, "Rodent thing with pants vs. midget mad scientist.", "./images/crash-bandicoot.png",
				"Running towards the screen", "Falling into unseen holes", "The gamedevs hate you", "Video game", "PS1", "3D", "Platformer"));

		reviewList.put(00003L, new Review("Video Game", "Portal 2", new Date(), 2011, "Free cake.  So delicious and moist.", "./images/portal.jpg", "Here's the test result:",
				"\"You're a horrible person.\"", "See? That's what it says.", "Video Game", "PC", "3D", "Puzzle", "Platformer"));

		reviewList.put(00004L, new Review("Video Game", "Super Mario World", new Date(), 1990, "Turtle boss must die. Again.", "./images/super-mario-world.jpg", "Fat Italian guy",
				"Eats shrooms and murders turtles", "Bowser never learns", "Video Game", "SNES", "2D", "Platformer"));

		reviewList.put(00005L, new Review("Video Game", "Undertale", new Date(), 2015, "Kill everybody... or don't.  Up to you.", "./images/undertale.jpg", "Here, I made you this",
				"Cinnamon-butterscotch pie", "Now be good, won't you?", "Video Game", "PC", "2D", "RPG"));
	}

	public OldReviewRepository(Review... reviews) {
		for (Review current : reviews) {
			reviewList.put(current.getId(), current);
		}
	}

	public Review getReviewByID(long id) {
		return reviewList.get(id);
	}

	public Collection<Review> getAllReviews() {
		return reviewList.values();
	}

}
