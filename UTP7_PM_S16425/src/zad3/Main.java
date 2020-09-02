/**
 *
 *  @author Piątkowski Marcin S16425
 *
 */

package zad3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Main extends JFrame{


	  public void showGui() {
		    SwingUtilities.invokeLater( new Runnable() {
		      public void run() {
		        JFrame f = new JFrame("Okno");
		        f.setPreferredSize(new Dimension(400,600));
		        f.pack();
		        f.setLocationRelativeTo(null);
		        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        f.setVisible(true);
		        f.setLayout(new GridLayout(10,3));
		        
		        
		        JButton add = new JButton("Dodaj");
		        JButton cencel = new JButton("Usun");
		        JButton show = new JButton("Podglad");
		        //tutaj
		     
		       
		       
		        
		        
		        
		        //koniec
		        f.add(add);
		        f.add(cencel);
		        f.add(show);
		      }
		    });
		  }
	  
	  public void add() {
		  
	  }
	  
	  public static void main(String[] args) {
		  Main main = new Main();
		    try {
		      main.showGui();
		    } catch(Exception exc) {
		      JOptionPane.showMessageDialog(null, "Table creation failed, " + exc);
		    }  
		  
	  }
	  
  }
