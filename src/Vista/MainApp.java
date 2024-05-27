package Vista;

import Controlador.ControladorMain;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        MiMarco miMarco = new MiMarco();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}
class MiMarco extends JFrame{
public MiMarco(){
    this.setTitle("Examen");
    this.setBounds(300, 200, 800, 500);
    MainPanel mainPanel= new MainPanel();
    add(mainPanel);
}
}
class MainPanel extends JPanel{

JPanel sur, norte,centro;
public MainPanel(){
    setLayout(new BorderLayout());
    sur = new PanelSur();
    centro= new PanelCentro();
    norte= new MenuPanel(this,centro);
    add(norte,BorderLayout.NORTH);
    add(sur,BorderLayout.SOUTH);
    add(centro,BorderLayout.CENTER);


}
}
class MenuPanel extends JPanel{
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem item1, item2, item3;

    public MenuPanel(MainPanel panelPrincipal,JPanel panelCentro){
        Panel1 panel1= new Panel1();
        Panel2 panel2= new Panel2();
        ControladorMain  controladorMain = new ControladorMain(panelPrincipal, panelCentro);
        menuBar= new JMenuBar();
        menu= new JMenu("menú");
        item1= new JMenuItem("item1");
        item2= new JMenuItem("item2");
        item3= new JMenuItem("Volver");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menuBar.add(menu);
        item1.addActionListener(e -> ControladorMain.nuevoPanelActivo(panel1));
        item2.addActionListener(e -> ControladorMain.nuevoPanelActivo(panel2));
        item3.addActionListener(e -> ControladorMain.nuevoPanelActivo(panelCentro));
        setLayout(new GridLayout(1,1));
        add(menuBar);
    }


}
class PanelCentro extends JPanel{
 public PanelCentro(){
     setLayout(new GridLayout(1,1));
     setBackground(Color.PINK);
 }
}
class   PanelSur extends JPanel{
    JButton añadir, modificar, eliminar;
    public PanelSur(){
       setLayout(new  GridLayout(1,3));
        setPreferredSize(new Dimension(800,50));
        add(añadir= new JButton("Añadir"));
        add(modificar= new JButton("Modificar"));
        add(eliminar= new JButton("Eliminar"));
    }
}
class Panel1 extends JPanel{
    public Panel1(){
        setLayout(new GridLayout(1,1));
        setBackground(Color.yellow);
        add(new Label("Panel 1"));
    }
}
class Panel2 extends JPanel{
    public Panel2(){
        setLayout(new GridLayout(1,1));
        setBackground(Color.green);
        add(new Label("Panel 2"));
    }
}
