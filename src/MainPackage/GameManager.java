package MainPackage;

import Event.Event1;

import java.io.IOException;

// How to Make Point and Click Adventure Game in Java Part 4
// 14 min 30 sec

public class GameManager {
    // need to initialize action handler before ui
    ActionHandler aHandler = new ActionHandler(this);
    public Event1 event = new Event1(this);
    public SceneChanger sChanger = new SceneChanger(this);
    // to invoke UI Class
    public UI ui = new UI(this);

    public static void main(String[] args) throws IOException {
        new GameManager();
    }

    public GameManager() throws IOException {

    }

    public void deadTunnel() {
        ui.messageText.setText("You Died Better next time");
        sChanger.showGameOverSceen();
    }
}
