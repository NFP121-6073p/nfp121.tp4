package question3;
import javax.swing.*;
import java.util.Observer;
import java.awt.FlowLayout;
import java.util.Observable;
import java.awt.Color;


/**
 * Write a description of class Vue2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vue2 extends JPanel implements Observer {

    // instance variables - replace the example below with your own
    private JSlider jauge;
  private PileModele<Integer> pile;


    /**
     * Constructor for objects of class Vue2
     */
    public Vue2(PileModele<Integer> pile)
    {
        super();
    this.pile = pile;
    this.jauge = new JSlider(JSlider.HORIZONTAL, 0, pile.capacite(), 0);
    this.jauge.setValue(0);
    setLayout(new FlowLayout(FlowLayout.CENTER));
    this.jauge.setEnabled(false);
    add(this.jauge);
    setBackground(Color.magenta);
    pile.addObserver(this);
}
       public void update(Observable obs, Object arg) {
    jauge.setValue(pile.taille());
  }
    }

   