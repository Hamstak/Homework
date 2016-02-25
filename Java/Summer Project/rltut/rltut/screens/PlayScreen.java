/*
 * 
 * 
 */
package rltut.screens;
 
import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import rltut.World;
import rltut.WorldBuilder;
import rltut.Creature;
import rltut.CreatureFactory;
import java.util.*;

public class PlayScreen implements Screen{
	
	private World world;
		private int screenWidth;
		private int screenHeight;
		private int currentDepth;
      private Creature player;
      private List<String> messages;
	
	public PlayScreen(){
		screenWidth = 80;
		screenHeight = 21;
      currentDepth = 1;
		createWorld();
		messages = new ArrayList<String>();
		CreatureFactory creatureFactory = new CreatureFactory(world);
		createCreatures(creatureFactory);
	}
	public void createCreatures(CreatureFactory creatureFactory){
		player = creatureFactory.newPlayer(messages);
		
		for(int i = 0; i < 8; i++){
			creatureFactory.newFungus(player);
		}
	}
	private void createWorld(){
		world = new WorldBuilder(30,50,5)
				.makeCaves()
				.build();
	}
	public int getScrollX(){
		return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth));
	}
	public int getScrollY(){
		return Math.max(0, Math.min(player.y - screenHeight/ 2, world.height() - screenHeight));
	}

	public void displayTiles(AsciiPanel terminal, int left, int top){
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int dx = x + left;
				int dy = y + top;
				
				Creature creature = world.creature(dx,dy, currentDepth);
				if (creature != null){
					terminal.write(creature.glyph(), creature.x-left, creature.y-top, creature.color());
				}else{
					terminal.write(world.glyph(dx,dy, currentDepth),x,y, world.color(dx,dy, currentDepth));
				}
			}
		}
	}
	public void displayOutput(AsciiPanel terminal){
		int left = getScrollX();
		int top = getScrollY();
		String stats = String.format("%3d/%3d",player.hp(),player.maxHP());
		
		displayTiles(terminal, left, top);
		terminal.write(player.glyph(),player.x - left, player.y - top,player.color());
		terminal.write(stats,1,23);
      displayMessages(terminal);
	}
	public Screen respondToUserInput(KeyEvent key){
		switch(key.getKeyCode()){
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_NUMPAD4: player.moveBy(-1,0,0);
			break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_NUMPAD6: player.moveBy(1,0,0);
			break;
			case KeyEvent.VK_UP:
			case KeyEvent.VK_NUMPAD8: player.moveBy(0,-1,0);
			break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_NUMPAD2: player.moveBy(0,1,0);
			break;
			case KeyEvent.VK_NUMPAD7: player.moveBy(-1,-1,0);
			break;
			case KeyEvent.VK_NUMPAD9: player.moveBy(1,-1,0);
			break;
			case KeyEvent.VK_NUMPAD1: player.moveBy(-1,1,0);
			break;
			case KeyEvent.VK_NUMPAD3: player.moveBy(1,1,0);
			break;
		}
		world.update();
		return this;
	}
	private void displayMessages(AsciiPanel terminal){
		int top = screenHeight - messages.size();
		
		for (int i=0; i < messages.size();i++){
			terminal.writeCenter(messages.get(i), top + i);
		}
		messages.clear();
	}
}

