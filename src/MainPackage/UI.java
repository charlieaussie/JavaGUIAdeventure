package MainPackage;

import Weapons.Dagger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class UI {
    Player player = new Player();
    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel hpPanel;
    public JLabel hpLabel;
    public JLabel weaponLabel;
    public JPanel weaponPanel;
    // array of panels and labels
    public JPanel[] bgPanel = new JPanel[10];
    public JLabel[] bgLabel = new JLabel[10];
    public Font normalFont = new Font("Book Antiqua", Font.PLAIN, 20);


    // Get GameManger class from UI class as well
    public UI(GameManager gm) {
        this.gm = gm;
        createMainField();
        // call generate screen that call create background and create object
        generateScene();
        // this make the window visable
        window.setVisible(true);
    }

    public void createMainField() {
        // Instantiate Window
        window = new JFrame();
        // set Window Size
        window.setSize(720, 600);
        // So user can close the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //The getContentPane() method retrieves the content pane layer so that you can add an object to it.
        window.getContentPane().setBackground(Color.black);
        // set Layout to the middle
        window.setLayout(null);

        messageText = new JTextArea("Dragon Lair");
        // Where to place the text to write
        messageText.setBounds(30, 420, 700, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        // This make so you cannot edit the text
        messageText.setEditable(false);
        // This will make lines in the text and not on a single line.
        messageText.setLineWrap(true);
        /*
           Makes the text not do this hell
           o my friend my nam
           e is samuel
         */
        messageText.setWrapStyleWord(true);
        // set the Font of the text and size of the text.
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        // This will add text area to the window
        window.add(messageText);
        // To display player Hp
        hpPanel = new JPanel();
        hpPanel.setBounds(20, 5, 60, 45);
        hpPanel.setBackground(Color.black);
        hpLabel = new JLabel("HP:" + player.hp);
        hpLabel.setForeground(Color.white);
        window.add(hpPanel);
        hpPanel.add(hpLabel);

        player.currentWeapon = new Dagger();
        // To Display Player Weapon
        weaponPanel = new JPanel();
        weaponPanel.setBounds(500, 5, 95, 45);
        weaponPanel.setBackground(Color.black);
        weaponLabel = new JLabel("Weapon: " + player.currentWeapon.weaponName);
        weaponLabel.setForeground(Color.white);
        window.add(weaponPanel);
        weaponPanel.add(weaponLabel);

    }

    public void gameOverGraveyard(int bgNum, String gameOverFile) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(1, 50, 1500, 350);
        bgPanel[bgNum].setBackground(Color.black);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);
        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, -45, 2600, 400);
        // This makes so I can display pictures in the GUI
        ImageIcon bgIcon;
        bgIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(gameOverFile)));
        bgLabel[bgNum].setIcon(bgIcon);
    }

    public void createBackground(int bgNum, String bgFileName) {
        // Panel for the background
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 1500, 350);
        bgPanel[bgNum].setBackground(Color.black);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, -45, 2600, 400);
// This makes so I can display pictures in the GUI
        ImageIcon bgIcon;
        bgIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(bgFileName)));
        bgLabel[bgNum].setIcon(bgIcon);


    }

    public void createTreasureChestObjet(int bgNum, int x, int y, int width, int height, String treasureFileName, String choice1, String command1) {
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem[] menuItem = new JMenuItem[1];
        menuItem[0] = new JMenuItem(choice1);
        menuItem[0].addActionListener(gm.aHandler);
        menuItem[0].setActionCommand(command1);
        popMenu.add(menuItem[0]);
        JLabel treasureChestLabel = new JLabel();
        treasureChestLabel.setBounds(x, y, width, height);
        ImageIcon treasureChestIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(treasureFileName)));
        treasureChestLabel.setIcon(treasureChestIcon);

        treasureChestLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // will look at your current mouse cursor
                    popMenu.show(treasureChestLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        {

        }

        // This code makes the image appear on the background
        bgPanel[bgNum].add(treasureChestLabel);

    }

    public void createObject(int bgNum, int objx, int objy, int objctWidth, int objectHeight, String objFileName,
                             String choic1Name, String choic2Name, String choic3Name, String choice1Command, String
                                     choice2Command, String choice3Command) {
        // create pop menu
        JPopupMenu popMenu = new JPopupMenu();
        // create menu items
        JMenuItem[] menuItem = new JMenuItem[3]; //Use [1] [2] [3]
        menuItem[0] = new JMenuItem(choic1Name);
        menuItem[0].addActionListener(gm.aHandler);
        menuItem[0].setActionCommand(choice1Command);
        popMenu.add(menuItem[0]);

        menuItem[1] = new JMenuItem(choic2Name);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(choice2Command);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choic3Name);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(choice3Command);
        popMenu.add(menuItem[2]);
        // create objects
        JLabel objectLabel = new JLabel();
        //objectLabel.setBounds(535, 160, 150, 110);
        objectLabel.setBounds(objx, objy, objctWidth, objectHeight);
        ImageIcon objectIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(objFileName)));
        objectLabel.setIcon(objectIcon);


        // object that can make the mouse click perform an action
        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // will look at your current mouse cursor
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        bgPanel[bgNum].add(objectLabel);

    }

    public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {

        ImageIcon arrowIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(arrowFileName)));
        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.aHandler);
        arrowButton.setActionCommand(command);
        // this make the border of the button disappear
        arrowButton.setBorderPainted(false);

        bgPanel[bgNum].add(arrowButton);

    }


    public void generateScene() {
        // Scene1
        createBackground(1, "cave-4701497_640.jpg");

        createObject(1, 400, 150, 250, 230, "wooden-sign.png",
                "...", "readSign", "look", "Enter",
                "readSign", "look");

        createObject(1, 1, 20, 400, 510, "knight-1300160_640.png",
                "Talk", "Attack", "Give", "talkGuard",
                "attackGuard", "giveRing");

        createArrowButton(1, 570, 110, 60, 60, "arrow-cursor (3).png",
                "goScene2");
        bgPanel[1].add(bgLabel[1]);

        //Scene2
        createBackground(2, "blueCave4701500_1280.png");
        createObject(2, 1, 110, 60, 60, "arrow-cursor (3).png",
                "Go Back", "", "", "goScene1",
                "", "");
        createTreasureChestObjet(2, 110, 100, 550, 350,
                "treasure-chest-575386_640.png", "Loot", "lootChest");
        bgPanel[2].add(bgLabel[2]);


        //Scene Game Over
        gameOverGraveyard(3, "woman-6011354_1280 (1).jpg");
        bgPanel[3].add(bgLabel[3]);


    }
}
