package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 赵哲
 * @version 1.0
 * 9:45
 * TankBattle
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;

    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel() {
        hero = new Hero(100, 100);
        hero.setSpeed(3);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//默认黑色的填充矩形
        //自己的坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        //敌人的坦克，遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
        }
    }

    /**
     * @param x      坦克的左上角 x 的坐标
     * @param y      坦克的左上角 y 的坐标
     * @param g      坦克的画笔
     * @param direct 坦克的方向（上下左右）
     * @param type   坦克的类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0 ->//我们的坦克
                    g.setColor(Color.cyan);
            case 1 ->//敌人的坦克
                    g.setColor(Color.YELLOW);
        }
        //根据不同方向绘制不同坦克
        //direct 表示方向（ 0：向上 1：向右 2：向下 3：向左）
        switch (direct) {
            case 0 -> {
                g.fill3DRect(x, y, 10, 60, false);//坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克中间的矩形
                g.fillOval(x + 10, y + 20, 20, 20);//坦克中间的圆盖
                g.drawLine(x + 20, y, x + 20, y + 30);//坦克的炮筒
            }
            case 1 -> {
                g.fill3DRect(x, y, 60, 10, false);//坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克中间的矩形
                g.fillOval(x + 20, y + 10, 20, 20);//坦克中间的圆盖
                g.drawLine(x + 60, y + 20, x + 30, y + 20);//坦克的炮筒
            }
            case 2 -> {
                g.fill3DRect(x, y, 10, 60, false);//坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克中间的矩形
                g.fillOval(x + 10, y + 20, 20, 20);//坦克中间的圆盖
                g.drawLine(x + 20, y + 60, x + 20, y + 30);//坦克的炮筒
            }
            case 3 -> {
                g.fill3DRect(x, y, 60, 10, false);//坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克中间的矩形
                g.fillOval(x + 20, y + 10, 20, 20);//坦克中间的圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);//坦克的炮筒
            }
            default -> System.out.println("暂时不做处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //改变坦克方向
            hero.setDirect(0);
            hero.moveUP();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
