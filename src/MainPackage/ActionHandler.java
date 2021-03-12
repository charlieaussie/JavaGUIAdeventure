package MainPackage;

import Event.Event1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    GameManager gm;
    Event1 event;

    public ActionHandler(GameManager gm) {
        this.gm = gm;

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();
        switch (yourChoice) {
            case "Enter":
                gm.event.enterCave();
                break;
            case "readSign":
                gm.event.readSign();
                break;
            case "look":
                gm.event.lookCave();
                break;
            case "talkGuard":
                gm.event.talkGuard();
                break;
            case "attackGuard":
                gm.event.attackGuard();
                break;
            case "giveRing":
                gm.event.giveRingToGuard();
                break;
            case "goScene1":
                gm.sChanger.showSceen1();
                break;
            case "goScene2":
                gm.sChanger.showSceen2();
                break;
            case "lootChest":
                gm.event.treasure();
                break;
            case "dead":
                gm.sChanger.showGameOverSceen();
                break;

        }

    }

}




