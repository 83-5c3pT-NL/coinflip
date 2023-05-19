/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinflip3;
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.util.Random;

// An AWT program inherits from the top-level container java.awt.Frame
public class Coinflip3 extends Frame {
    private Label aantalmeerkoplabel, aantallabel, streeplabel, streeplabel2, streeplabel3, paullabel;    // Declare a Label component
    private Button startknop;
    private TextField aantalmeerkoptekstvak,aantalfliptekst, aantalkoptekst, aantalmunttekst, aantalmeerkoptekst;
    private String aantalmeerkopinvoer = "";
    private int aantalmeerkopgevraagd, aantalflip, aantalkop, aantalmunt, flipuitkomst, aantalmeerkop;

   // Constructor to setup GUI components and event handlers
   public Coinflip3 () {
      setLayout(new FlowLayout());
         // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
         // the components from left-to-right, and flow to next row from top-to-bottom.

        aantalmeerkoplabel = new Label("Aantal keer dat je meer kop wilt gooien : ");  // construct the Label component
        add(aantalmeerkoplabel); 
         
        aantalmeerkoptekstvak = new TextField ("");
        add(aantalmeerkoptekstvak);

        streeplabel = new Label("o--------------------------------------------------------o");  // construct the Label component
        add(streeplabel);
        
        aantallabel = new Label("Aantal keer gegooid : ");  // construct the Label component
        add(aantallabel);        
        
        aantalfliptekst = new TextField (" aantal keer geflipt = " + aantalflip);
        aantalfliptekst.setEditable(false);
        add(aantalfliptekst);        
 
        aantalkoptekst = new TextField (" aantal keer kop =  " + aantalkop);
        aantalkoptekst.setEditable(false);
        add(aantalkoptekst);        
 
        aantalmunttekst = new TextField ("aantal keer munt =  " + aantalmunt);
        aantalmunttekst.setEditable(false);
        add(aantalmunttekst);        

        aantalmeerkoptekst = new TextField ("aamtal keer meer kop dan munt =  " + aantalmeerkop);
        aantalmeerkoptekst.setEditable(false);
        add(aantalmeerkoptekst);        

        streeplabel2 = new Label("o--------------------------------------------------------o");  // construct the Label component
        add(streeplabel2);

        startknop = new Button ("start flippen");
        add(startknop); 

        streeplabel3 = new Label("o--------------------------------------------------------o");  // construct the Label component
        add(streeplabel3);  

        paullabel = new Label("<c> Paul Spaan");  // construct the Label component
        add(paullabel);
        

        startknopListener listener = new startknopListener();
        startknop.addActionListener(listener);
         // "btnCount" is the source object that fires an ActionEvent when clicked.
         // The source object adds an instance of BtnCountListener as an ActionEvent listener,
         //   which provides an ActionEvent handler called actionPerformed().
         // Clicking "Count" button calls back actionPerformed().

        setTitle("The Coinflip V3.5, A lesson in 'chance-calculation' and 'window-resolution'");  // "super" Frame sets its title
        setSize(300, 360);        // "super" Frame sets its initial window size

      // For inspecting the Container/Components objects
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
        setVisible(true);         // "super" Frame shows
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
   }

   // The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
        Coinflip3 app = new Coinflip3();
         // or sAWTCounterimply "new AWTCounter();" for an anonymous instance
   }

   // Define an inner class to handle the "Count" button-click
   private class startknopListener implements ActionListener {
      // ActionEvent handler - Called back upon button-click.
        @Override
        public void actionPerformed(ActionEvent evt) {
            aantalmeerkopinvoer = aantalmeerkoptekstvak.getText();
            aantalmeerkopgevraagd = Integer.parseInt(aantalmeerkopinvoer);

            for (aantalflip = 1; aantalmeerkop < aantalmeerkopgevraagd; aantalflip++) {
                Random x = new Random();
                flipuitkomst = x.nextInt(2);

                    
                if (flipuitkomst == 0) {
                    aantalkop = aantalkop + 1;
                }
                    
                if (flipuitkomst == 1) {
                    aantalmunt = aantalmunt + 1;
                }                            
                
                aantalmeerkop = aantalkop - aantalmunt;
                aantalfliptekst.setText (" aantal keer geflipt = " + aantalflip);
                aantalkoptekst.setText (" aantal keer kop =  " + aantalkop);
                aantalmunttekst.setText ("aantal keer munt =  " + aantalmunt);
                aantalmeerkoptekst.setText ("aantal keer meer kop dan munt =  " + aantalmeerkop);
            }
            
            aantalkop = 0;
            aantalmunt = 0;    
            aantalmeerkop = 0;
                    
        }
   }
}
