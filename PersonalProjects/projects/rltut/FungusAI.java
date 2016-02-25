/*
 *
 *
 */
package rltut;

public class FungusAI extends CreatureAI {
    private CreatureFactory factory;
    private int spreadcount;

    public FungusAI(Creature creature, CreatureFactory factory){
        super(creature);
        this.factory = factory;
    }

    public void onUpdate(){
        if (spreadcount < 5 && Math.random() < 0.02)
            spread();
    }
    public void spread(){
        int x = creature.x + (int)(Math.random() * 11) - 5;
        int y = creature.y + (int)(Math.random() * 11) - 5;

        if(!creature.canEnter(x,y,creature.z)){
            return;
        }

        Creature child = factory.newFungus(creature);
        child.x = x;
        child.y = y;
        child.z = creature.z;
        spreadcount++;
        creature.doAction("spawn a child");
    }
}

