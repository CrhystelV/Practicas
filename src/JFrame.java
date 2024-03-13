import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JFrame extends javax.swing.JFrame {
    public void mostrarPanels() {
        JFrame frame = new JFrame();
        Icon icon = new ImageIcon("src//Recursos//descarga.png");
        JButton boton = new JButton(icon);
        boton.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        frame.add(boton);
        frame.setVisible(true);

        /*JButton button = new JButton();
        try{
            Image imagen = ImageIO.read(getClass().getResource("C:/Users/Usuario/IdeaProjects/Interface/descarga.png"));
            button.setIcon(new ImageIcon(imagen));
        }
        catch(IOException ex) {
            System.out.println(ex);
        }*/
    }

}
