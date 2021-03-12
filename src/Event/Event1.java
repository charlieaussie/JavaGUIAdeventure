package Event;

import MainPackage.GameManager;
import MainPackage.Player;
import Weapons.Axe;

import java.awt.*;

public class Event1 {
    Player player = new Player();
    GameManager gm;
    public int goldRing = 0;
    public int guardAttack = 0;

    public Event1(GameManager gm) {
        this.gm = gm;

    }

    public void enterCave() {
        gm.ui.messageText.setText("Boring to just wait outside.....");
        gm.ui.messageText.setForeground(Color.green);
        gm.ui.messageText.setFont(gm.ui.normalFont);
        gm.ui.messageText.setLineWrap(true);
    }

    public void readSign() {
        gm.ui.messageText.setText("Go Back Adventure this is a Troll Cave");
        gm.ui.messageText.setForeground(Color.red);
        gm.ui.messageText.setLineWrap(true);
        gm.ui.messageText.setFont(new Font("Big scary letter", Font.BOLD, 24));

    }

    public void treasure() {
        gm.ui.messageText.setText("You are opening the treasure chest\nYou found a Gold ring.");
        gm.ui.messageText.setForeground(Color.white);
        gm.ui.messageText.setLineWrap(true);
        goldRing = 1;

    }

    public void lookCave() {
        gm.ui.messageText.setText("You are idling outside the cave");
        gm.ui.messageText.setForeground(Color.white);
        gm.ui.messageText.setLineWrap(true);

    }

    public void talkGuard() {
        gm.ui.messageText.setText("Guard: Hello Adventurer! This is no place for a weakling such as you.\nGo back to where you came from");
        gm.ui.messageText.setForeground(Color.cyan);
        gm.ui.messageText.setLineWrap(true);
    }

    public void attackGuard() {
        guardAttack++;
        if (guardAttack > 1) {
            player.setHp(0);
            gm.ui.hpLabel.setText("HP:" + player.hp);
            gm.deadTunnel();

        } else {
            gm.ui.messageText.setText("The Guard Gives you a hard punch\nStop that you weakling or I kill you");
            gm.ui.messageText.setForeground(Color.cyan);
            gm.ui.messageText.setLineWrap(true);
            player.hp = player.hp - 3;
            guardAttack = guardAttack + 1;
            gm.ui.hpLabel.setText("HP:" + player.hp);
        }

    }

    public void giveRingToGuard() {
        if (goldRing == 1) {
            gm.ui.messageText.setText("Guard: Thank you for the Ring.\nI will give you an Axe for your trouble");
            // This two last codes makes the new weapon name appear
            player.currentWeapon = new Axe();
            gm.ui.weaponLabel.setText("Weapon: " + player.currentWeapon.weaponName);
            gm.ui.messageText.setForeground(Color.cyan);
            gm.ui.messageText.setLineWrap(true);
            goldRing--;
        } else {
            gm.ui.messageText.setText("You have nothing to give to the guard");
        }

    }

}

