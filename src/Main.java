import javax.swing.SwingUtilities;

import game.GUI.Frame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Frame::new);
    }
}