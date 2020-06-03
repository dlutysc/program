package book;

import javax.swing.*;
import java.util.Comparator;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();
        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
