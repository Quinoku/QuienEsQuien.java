package Programacion;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PantallaInicio {

    public static void main(String[] args) {

        FrameInicio marco = new FrameInicio();

        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// clase para el frame de la pantalla de inicio

class FrameInicio extends JFrame {

    public FrameInicio() {

        setTitle("Pantalla de inicio");
        setBounds(200, 150, 1000, 860);

        LaminaInicio inicio = new LaminaInicio("src/Programacion/IMG/Fondo.jpg");
        add(inicio);
    }

}

// clase para la lámina del frame

class LaminaInicio extends JPanel {

    private Image fondo;

    // contructor que pide como parámetro la ruta de la imagen de fondo

    public LaminaInicio(String rutaImagen) {
        this.fondo = Toolkit.getDefaultToolkit().getImage(rutaImagen);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // añade la imagen de fondo con el tamaño del frame

        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);

        // añade titulo del juego y otra información

        g.setFont(new Font("SansSerif", Font.BOLD, 80));
        g2.setPaint(Color.WHITE);
        g.drawString("¿QUIÉN ES QUIÉN?", 120, 120);

        g.setFont(new Font("SansSerif", Font.BOLD, 40));
        g2.setPaint(new Color(254, 249, 231));
        g.drawString("Con personajes de Nintendo", 200, 190);

        // añade tres rectángulos con las opciones Jugar, Ver Puntuaciones y Salir

        Rectangle2D rectJugar = new Rectangle2D.Double(500,280,360 ,120);
        Rectangle2D rectPuntuaciones = new Rectangle2D.Double(500,430,360,120);
        Rectangle2D rectSalir = new Rectangle2D.Double(500,580,360,120);
        g2.setPaint(new Color(34, 153, 84));
        g2.fill(rectJugar);
        g2.setPaint(new Color(243, 156, 18));
        g2.fill(rectPuntuaciones);
        g2.setPaint(new Color(192, 57, 43  ));
        g2.fill(rectSalir);

        g.setFont(new Font("Verdana", Font.BOLD, 36));
        g2.setPaint(Color.WHITE);
        g.drawString("INICIO", 606, 350);
        g.drawString("PUNTUACIONES", 518, 500);
        g.drawString("SALIR", 616, 650);
    }
}