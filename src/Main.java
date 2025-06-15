import GUI.IntroWindow;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new IntroWindow().setVisible(true);

        });
    }
}



