package Programacion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class PantallaJuego {

    public static void main(String[] args) {

        FrameJuego marco = new FrameJuego();

        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// clase para el frame del juego

class FrameJuego extends JFrame {

    public FrameJuego() {

        setTitle("¿Quién es quién?");
        setBounds(200, 150, 1000, 860);

        LaminaJuego personajes = new LaminaJuego();
        personajes.setBackground(new Color(254, 249, 231));
        add(personajes);

    }
}

// clase para una lámina del juego

class LaminaJuego extends JPanel {

    private Image mario;
    private Image luigi;
    private Image bowser;
    private Image peach;
    private Image daisy;
    private Image link;
    private Image toad;
    private Image canela;
    private Image toaddete;

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        try {
            // lee las imagenes

            mario = ImageIO.read(new File("src/Programacion/IMG/Mario.jpg"));
            luigi = ImageIO.read(new File("src/Programacion/IMG/Luigi.jpg"));
            bowser = ImageIO.read(new File("src/Programacion/IMG/Bowser.jpg"));
            peach = ImageIO.read(new File("src/Programacion/IMG/Peach.jpg"));
            daisy = ImageIO.read(new File("src/Programacion/IMG/Daisy.jpg"));
            link = ImageIO.read(new File("src/Programacion/IMG/Link.jpg"));
            toad = ImageIO.read(new File("src/Programacion/IMG/Toad.jpg"));
            canela = ImageIO.read(new File("src/Programacion/IMG/Canela.jpg"));
            toaddete = ImageIO.read(new File("src/Programacion/IMG/Toaddete.jpg"));

        } catch (IOException e) {
            System.out.println("No se ha podido encontrar alguna imagen");
        }

        // añade las imágenes de los personas

        g.drawImage(mario, 50, 50, 120, 200, null);
        g.drawImage(luigi, 220, 50, 120, 200, null);
        g.drawImage(bowser, 390, 50, 120, 200, null);
        g.drawImage(peach, 50, 300, 120, 200, null);
        g.drawImage(daisy, 220, 300, 120, 200, null);
        g.drawImage(link, 390, 300, 120, 200, null);
        g.drawImage(toad, 50, 550, 120, 200, null);
        g.drawImage(canela, 220, 550, 120, 200, null);
        g.drawImage(toaddete, 390, 550, 120, 200, null);

        // añade las preguntas

        g.setFont(new Font("Verdana", Font.BOLD, 30));
        g2.setPaint(Color.BLACK);
        g.drawString("PREGUNTAS:", 660, 80);
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g2.setPaint(new Color(86, 101, 115));
        g.drawString("¿Es hombre?", 700, 130);
        g.drawString("¿Es mujer?", 704, 170);
        g.drawString("¿Es alto?", 710, 210);
        g.drawString("¿Es bajo?", 710, 250);
        g.drawString("¿Es humano?", 698, 290);
        g.drawString("¿Lleva pantalones?", 660, 330);
        g.drawString("¿Lleva gorra?", 686, 370);
        g.drawString("¿Lleva corona?", 682, 410);
        g.drawString("¿Es rubio?", 704, 450);
        g.drawString("¿Es moreno?", 700, 490);

        // dibuja unos rectángulos e incluye las palabras SI y NO

        Rectangle2D rectanguloSi = new Rectangle2D.Double(660,550,110,90);
        Rectangle2D rectanguloNo = new Rectangle2D.Double(790,550,110,90);
        g2.setPaint(new Color(88, 214, 141));
        g2.fill(rectanguloSi);
        g2.setPaint(new Color(231, 76, 60));
        g2.fill(rectanguloNo);

        g.setFont(new Font("Verdana", Font.BOLD, 50));
        g2.setPaint(Color.WHITE);
        g.drawString("SI", 682, 610);
        g.drawString("NO", 802, 610);

        // dibuja una elipse y la palabra RESOLVER

        Ellipse2D elipse = new Ellipse2D.Double(660,660, 240, 150);
        g2.setPaint(new Color(210, 180, 222));
        g2.fill(elipse);

        g.setFont(new Font("Courier", Font.BOLD, 44));
        g2.setPaint(Color.BLACK);
        g.drawString("RESOLVER", 676, 750);
    }
}
