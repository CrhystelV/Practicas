import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PorCambiarNombre {
    private JButton origenBoton;

    public PorCambiarNombre() {
        origenBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MuestraDeVariasEspecies muestraDeVariasEspecies = new MuestraDeVariasEspecies();
                JOptionPane.showInputDialog(origenBoton, "holis");
            }
        });
    }
}
