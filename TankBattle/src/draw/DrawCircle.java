package draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author 赵哲
 * @version 1.0
 * 21:54
 * TankBattle
 */
@SuppressWarnings({"all"})
public class DrawCircle extends JFrame {//JFrame对应一个窗口

    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("退出程序.....");
    }

    public DrawCircle() {
        //初始化面板
        mp = new MyPanel();
        //把面板放置的画框里
        this.add(mp);
        //设置画框的大小
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //可以显示
        this.setVisible(true);
    }
}

//定义一个MyPanel类,继承JPanel类，画图象
class MyPanel extends JPanel {

    //MyPanel对象是一个画板
    //Graphics g 就是一个画笔
    //Graphics 提供了很多画图方法
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
        //g.drawOval(50, 50, 300, 300);


        //g.drawLine(10,10,100,100);//直线
        //g.drawRect(10,10,100,100);//矩形边框
        //g.fillRect(10,10,100,100);//填充矩形
        //g.fillOval(10,10,100,100);//填充椭圆
        //g.drawString("赵哲是帅哥",10,10);//画字符串
        //先获取图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bg.png"));
        g.drawImage(image,10,10,360,165,this);//画图片
        //给画笔设置字体和颜色
        //g.setColor(Color.MAGENTA);
        //g.setFont(new Font("隶书",Font.BOLD,50));
        //这里的100是左下角
        //g.drawString("赵哲好帅",100,100);
    }
}