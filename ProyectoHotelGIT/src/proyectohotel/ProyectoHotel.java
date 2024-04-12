package proyectohotel;
import Vista.*;
import javax.swing.JFrame;

public class ProyectoHotel {

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);
        // Configurar la operación por defecto al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
