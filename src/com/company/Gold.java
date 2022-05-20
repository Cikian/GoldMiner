package com.company;

import java.awt.*;

public class Gold extends Object {

    Gold() {
        this.x = (int) (Math.random() * 700);
        this.y = (int) (Math.random() * 550 + 300);
        this.width = 52;
        this.height = 52;
        this.flag = false;
        this.m = 30;
        this.count = 250;
        this.type = 1;
        this.img = Toolkit.getDefaultToolkit().getImage("imgs/gold1.gif");
    }
}

class GoldMini extends Gold {
    GoldMini() {
        this.width = 36;
        this.height = 36;
        this.m = 30;
        this.count = 150;
        this.img = Toolkit.getDefaultToolkit().getImage("imgs/gold0.gif");
    }
}

class GoldPlus extends Gold {
    GoldPlus() {
        this.x = (int) (Math.random() * 650);
        this.width = 105;
        this.height = 105;
        this.m = 100;
        this.count = 500;
        this.img = Toolkit.getDefaultToolkit().getImage("imgs/gold2.gif");
    }
}
