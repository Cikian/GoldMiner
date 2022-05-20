package com.company;

import java.awt.*;

public class Bg {
    // 关卡数
    static int level = 1;
    // 目标得分
    int goal = (level * 500) + 550;
    // 总分
    static int count = 0;
    // 药水数量
    static int waterNum = 3;
    // 药水状态
    static boolean waterFlag = false;
    // 开始时间
    long startTime;
    // 结束时间
    long endTime;
    // 药水价格
    int price = (int) (Math.random() * 10);
    // 是否进入商店 f不购买
    boolean shop = false;

    // 载入图片
    Image bg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    Image bg1 = Toolkit.getDefaultToolkit().getImage("imgs/bg1.jpg");
    Image peo = Toolkit.getDefaultToolkit().getImage("imgs/peo.png");
    Image water = Toolkit.getDefaultToolkit().getImage("imgs/water.png");

    // 绘制
    void paintSelf(Graphics g) {
        g.drawImage(bg, 0, 200, null);
        g.drawImage(bg1, 0, 0, null);
        switch (GameWin.state) {
            case 0:
                drawWord(g, 80, Color.black, "按鼠标右键开始", 100, 400);
                drawWord(g, 60, Color.red, "游戏规则：", 100, 500);
                drawWord(g, 30, Color.black, "点击鼠标左键放出抓钩", 100, 560);
                drawWord(g, 30, Color.black, "抓住金块或石头可以点击鼠标右键", 100, 620);
                drawWord(g, 30, Color.black, "使用“大力神药”快速收回金块或者爆破石头", 100, 680);
                break;
            case 1:
                g.drawImage(peo, 310, 50, null);
                drawWord(g, 30, Color.black, "分数：" + count, 30, 150);
                g.drawImage(water, 550, 40, null);
                drawWord(g, 30, Color.black, "×" + waterNum, 610, 90);
                // 关卡数&目标得分
                drawWord(g, 20, Color.black, "关卡：" + level, 30, 60);
                drawWord(g, 30, Color.black, "目标：" + goal, 30, 115);
                // 实时赋值
                endTime = System.currentTimeMillis();
                long time = 20 - (endTime - startTime) / 1000;
                drawWord(g, 30, Color.black, "时间：" + (time > 0 ? time : 0), 520, 150);
                break;
            case 2:
                g.drawImage(water, 330, 380, null);
                drawWord(g, 30, Color.black, "价格：" + price, 300, 500);
                drawWord(g, 30, Color.black, "是否购买“大力神药”？", 280, 550);
                drawWord(g, 30, Color.black, "点击鼠标左键确认购买，右键退出商店", 100, 700);

                if (shop) {
                    count = count - price;
                    waterNum++;
                    shop = false;
                    GameWin.state = 1;
                    startTime = System.currentTimeMillis();
                }
                break;
            case 3:
                drawWord(g, 80, Color.cyan, "失败", 300, 350);
                drawWord(g, 80, Color.black, "分数：" + count, 200, 450);
                drawWord(g, 60, Color.black, "点击鼠标左键重新开始", 90, 550);
                break;
            case 4:
                drawWord(g, 80, Color.red, "恭喜过关", 250, 350);
                drawWord(g, 80, Color.black, "分数：" + count, 200, 450);
                drawWord(g, 60, Color.black, "点击鼠标左键重新开始", 90, 550);
                break;
            default:
        }

    }

    // t倒计时完成，f未完成倒计时
    boolean gameTime() {
        long time = (endTime - startTime) / 1000;
        if (time >= 20) {
            return true;
        }
        return false;
    }

    // 重置元素
    void reGame() {
        // 关卡数
        level = 1;
        // 目标得分
        goal = (level * 500) + 550;
        // 总分
        count = 0;
        // 药水数量
        waterNum = 3;
        // 药水状态
        waterFlag = false;
    }

    // 绘制字符串
    public static void drawWord(Graphics g, int size, Color color, String str, int x, int y) {
        g.setColor(color);
        g.setFont(new Font("宋体", Font.BOLD, size));
        g.drawString(str, x, y);

    }

}
