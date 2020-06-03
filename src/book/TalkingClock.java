package book;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Date;

public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        Timer t = new Timer(interval, e -> {
            System.out.println(new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        });
        t.start();
    }


}
