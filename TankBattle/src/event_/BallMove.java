package event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 赵哲
 * @version 1.0
 * 10:34
 * TankBattle
 */
public class BallMove extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
//KeyListener 一个监听器 监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    //键盘监听有字符输出时，就会触发该方法
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某一个键按下后就会触发该方法
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {//KeyEvent.VK_DOWN 是向下箭头对应的code
            y++;
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            y--;
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            x--;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            x++;
        }
//        让代码自动重绘
            this.repaint();
    }

    //当某一个键释放（松开）后就会触发该方法
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
