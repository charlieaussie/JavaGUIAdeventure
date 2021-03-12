package MainPackage;

public class SceneChanger {
    GameManager gm;

    public SceneChanger(GameManager gm) {
        this.gm = gm;
    }

    public void showSceen1() {
        //This will make on screen to appear at one time ant not on the same time
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);

    }

    public void showSceen2() {
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.bgPanel[3].setVisible(false);

    }

    public void showGameOverSceen() {
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(true);
    }
}
