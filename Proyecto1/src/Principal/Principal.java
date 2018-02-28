package Principal;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Joaquin
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
          
    /*    Home h = new Home();
        h.setVisible(true);
  */
                    UsacWeb frame1 = new UsacWeb();
             
                     frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);

frame1.setMinimumSize(new Dimension(800, 600)); 


                     frame1.setVisible(true); 

                      
      
    }
    
}
