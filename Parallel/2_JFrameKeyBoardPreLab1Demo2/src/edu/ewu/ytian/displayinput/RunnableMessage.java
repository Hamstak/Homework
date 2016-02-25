package edu.ewu.ytian.displayinput;

import javax.swing.*;

/**
 * Created by moth on 1/12/16.
 */
public class RunnableMessage implements Runnable{
    String name;
    JTextArea output;
    public RunnableMessage(String name, JTextArea output){
        this.name = name;
        this.output = output;
    }
    public void run(){
        while(!Thread.interrupted()){
            output.append("Message from thread --> " +this.name + '\n');
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                break;
            }
        }
        output.append(this.name + " Gets interrupted! Terminate!\n");
    }
}
