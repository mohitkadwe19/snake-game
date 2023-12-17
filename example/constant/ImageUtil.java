package example.constant;

import example.helper.GameUtil;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class ImageUtil
{
	public static Map<String, Image> images = new HashMap<>();

	static
	{
		// snake
		images.put("snake-head-right", GameUtil.getImage("example/Images/snake-head-right.png"));
		images.put("snake-body", GameUtil.getImage("example/Images/snake-body.png"));
		// obstacles
		images.put("0", GameUtil.getImage("example/Images/food-kiwi.png"));
		images.put("1", GameUtil.getImage("example/Images/food-lemon.png"));
		images.put("2", GameUtil.getImage("example/Images/food-litchi.png"));
		images.put("3", GameUtil.getImage("example/Images/food-mango.png"));
		images.put("4", GameUtil.getImage("example/Images/food-apple.png"));
		images.put("5", GameUtil.getImage("example/Images/food-banana.png"));
		images.put("6", GameUtil.getImage("example/Images/food-blueberry.png"));
		images.put("7", GameUtil.getImage("example/Images/food-cherry.png"));
		images.put("8", GameUtil.getImage("example/Images/food-durian.png"));
		images.put("9", GameUtil.getImage("example/Images/food-grape.png"));
		images.put("10", GameUtil.getImage("example/Images/food-grapefruit.png"));
		images.put("11", GameUtil.getImage("example/Images/food-peach.png"));
		images.put("12", GameUtil.getImage("example/Images/food-pear.png"));
		images.put("13", GameUtil.getImage("example/Images/food-orange.png"));
		images.put("14", GameUtil.getImage("example/Images/food-pineapple.png"));
		images.put("15", GameUtil.getImage("example/Images/food-strawberry.png"));
		images.put("16", GameUtil.getImage("example/Images/food-watermelon.png"));
		images.put("UI-background", GameUtil.getImage("example/Images/UI-background.png"));
		images.put("game-scene-01", GameUtil.getImage("example/Images/game-scene-01.jpg"));
		images.put("restart-game", GameUtil.getImage("example/Images/restart-game.png"));
		images.put("resume-game", GameUtil.getImage("example/Images/resume-game.png"));
		images.put("start-game", GameUtil.getImage("example/Images/start-game.png"));
		images.put("pause-game", GameUtil.getImage("example/Images/pause-game.png"));
	}
}
