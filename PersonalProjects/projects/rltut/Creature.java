/*
 *
 *
 */
package rltut;

import java.awt.Color;
import rltut.World;

public class Creature {

    private World world;

    public int x;
    public int y;
    public int z;

    private int maxHP;
    public int maxHP(){ return maxHP; }

    private int hp;
    public int hp(){ return hp; }

    private int attackValue;
    public int attackValue(){ return attackValue; }

    private int defenseValue;
    public int defenseValue(){ return defenseValue; }

    private char glyph;
    public char glyph(){ return glyph; }

    private Color color;
    public Color color(){ return color; }

    private CreatureAI ai;
    public void setCreatureAI(CreatureAI ai){ this.ai = ai; }

    public void dig(int wx, int wy){
        world.dig(wx,wy,z);
        doAction("hear a digging sound");
    }

    public void moveBy (int mx, int my, int mz){
        Tile tile = world.tiles(x+mx, y+my, z+mz);

        if(mz == -1){
            if (tile == Tile.STAIRS_DOWN){
                doAction("walk up the stairs to level %d", z+mz+1);
            }else{
                doAction("try to go up, but are stopped by the cave ceilling");
                return;
            }
        }else if (mz == 1){
            if (tile == Tile.STAIRS_UP){
                doAction("walk down the stairs to level %d", z+mz+1);
            }else{
                doAction("try to go down, but are stopped by the cave floor");
                return;
            }
        }
        Creature other = world.creature(x+mx, y+my, z+mz);

        if(other == null){
            ai.onEnter(x+mx, y+my, z +mz, tile);
        }else{
            attack(other);
        }
    }

    public void attack(Creature other){
        int amount = Math.max(0,attackValue() - defenseValue());
        amount = (int)(Math.random() * amount) + 1;
        other.modifyHP(-amount);
        doAction("attack the '%s' for %d damage", other.glyph, amount);
    }

    public void modifyHP(int amount){
        hp += amount;

        if(hp <= 0){
            doAction("die");
            world.remove(this);
        }
    }

    public void update(){
        ai.onUpdate();
    }

    public void notify(String message, Object ... params){
        ai.onNotify(String.format(message,params));
    }

    public void doAction(String message, Object ... params){
        int r = 9;
        for (int ox = 0; ox < r+1;ox++){
            for (int oy = 0; oy < r+1;oy++){
                if (ox*ox + oy*oy > r*r)
                    continue;

                Creature other = world.creature(x+ox,y+oy, z);

                if (other == null)
                    continue;

                if (other == this)
                    if (message.equals("hear a digging sound"))
                        continue;
                    else
                        notify("You " + message + ".",params);
                else
                if (message.equals("hear a digging sound"))
                    notify("You " + message + ".");
                else
                    other.notify(String.format("The '%s' %s.",glyph(),makeSecondPerson(message)),params);
            }
        }
    }

    private String makeSecondPerson(String text){
        String[] words = text.split(" ");
        words[0] = words[0] + "s";

        StringBuilder builder = new StringBuilder();
        for (String word: words){
            builder.append(" ");
            builder.append(word);
        }
        return builder.toString().trim();
    }

    public Creature(World world, char glyph, Color color, int maxHP, int attackValue, int defenseValue){
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;

    }
    public boolean canEnter(int x,int y,int z){
        return world.tiles(x,y,z).isGround();
    }
}

