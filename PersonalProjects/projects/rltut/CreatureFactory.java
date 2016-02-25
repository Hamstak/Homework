/*
 *
 *
 */
package rltut;

import asciiPanel.AsciiPanel;
import java.util.List;

public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }

    public Creature newPlayer(List<String> messages){
        Creature player = new Creature(world, '@', AsciiPanel.brightWhite, 100, 20 ,5);
        world.addAtEmptyLocation(player, 0);
        new PlayerAI(player, messages);
        return player;
    }

    public Creature newFungus(Creature player){
        Creature fungus = new Creature(world,'f',AsciiPanel.green,10,0,0);
        world.addAtEmptyLocation(fungus, player.z);
        new FungusAI(fungus, this);
        return fungus;
    }
}

