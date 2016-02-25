import java.awt.*;

class FixedPhilosopher extends Thread {

    int identity;
    boolean stopRequested = false;
    PhilCanvas view;
    Diners controller;
    Fork left;
    Fork right;

    FixedPhilosopher(Diners controller, int identity, Fork left, Fork right) {
        this.controller = controller;
        this.view = controller.display;
        this.identity = identity;
        this.left = left;
        this.right = right;
    }

    public void run() {
        while (!stopRequested) {
             try {
                 //thinking
                 view.setPhil(identity, view.THINKING);
                 sleep(controller.sleepTime());
                 //hungry
                 while(true){
                    view.setPhil(identity, view.HUNGRY);
                    //get forks
                    if (right.getIdentity() < left.getIdentity()) {
                        if (right.get()) {
                             view.setPhil(identity, view.GOTRIGHT);
                             if (!left.get()) {
                                 right.put();
                                 continue;
                             }
                         } else {
                             continue;
                         }
                    } else {
                         if (left.get()) {
                             view.setPhil(identity, view.GOTLEFT);
                            if (!right.get()) {
                                 left.put();
                                continue;
                            }
                        } else {
                            continue;
                         }
                    }
                    //eating
                    view.setPhil(identity, view.EATING);
                     System.out.println("Philosopher " + identity + " is eating!");
                    sleep(controller.eatTime());
                    right.put();
                    left.put();
                     break;
                }
             } catch (java.lang.InterruptedException e) {}
        }
    }


    public void stopRequested() {
        stopRequested = true;
    }

}
