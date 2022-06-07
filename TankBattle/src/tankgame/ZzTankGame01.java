package tankgame;

import javax.swing.*;

/**
 * @author 赵哲
 * @version 1.0
 * 9:49
 * TankBattle
 */
public class ZzTankGame01 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        ZzTankGame01 zzTankGame01 = new ZzTankGame01();
    }
    public ZzTankGame01(){
        mp =new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
