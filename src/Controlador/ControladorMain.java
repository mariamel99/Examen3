package Controlador;

import javax.swing.*;


public class ControladorMain {
    static JPanel panelActivo, panelPadre;
    public  ControladorMain(JPanel panel1,JPanel panel2){
        panelPadre = panel1;
        panelActivo = panel2;
        panelPadre.add(panelActivo);
    }
    public static void nuevoPanelActivo(JPanel nuevoPanel){
        panelPadre.remove(panelActivo);
        panelPadre.add(nuevoPanel);
        panelPadre.revalidate();
        panelPadre.repaint();
        panelActivo = nuevoPanel;
    }

    public static JPanel getPanelActivo() {
        return panelActivo;
    }
}
