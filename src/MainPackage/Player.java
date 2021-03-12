package MainPackage;

import Weapons.SuperWeapon;

public class Player {
    public SuperWeapon currentWeapon;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (hp > MAXHP) {
            hp = 30;
        } else if (hp < 0) {
            hp = 0;

        }
    }

    public int hp = 20;
    final int MAXHP = 30;


}
