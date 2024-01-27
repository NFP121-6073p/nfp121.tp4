package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;
/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);
        
        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");
        
        add.setEnabled(false);
        sub.setEnabled(false);
        mul.setEnabled(false);
        div.setEnabled(false);
        
        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est à remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new PushListener()); /* null est à remplacer */
        boutons.add(add);   add.addActionListener(new AddListener()); /* null est à remplacer */
        boutons.add(sub);   sub.addActionListener(new SubListener()); /* null est à remplacer */
        boutons.add(mul);   mul.addActionListener(new MulListener()); /* null est à remplacer */
        boutons.add(div);   div.addActionListener(new DivListener()); /* null est à remplacer */
        boutons.add(clear); clear.addActionListener(new ClearListener()); /* null est à remplacer */
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        donnee.setText("");// à compléter
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    // à compléter
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)
    class PushListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int val = 0;
            try{
                val = operande();
                pile.empiler(val);
            }
            catch(NumberFormatException nfe){
                return;
            }
            catch(PilePleineException ppe){
                return;
            }
            toggleButtons();
            donnee.setText("");
        }
    }
    
    class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.empiler(pile.depiler()+pile.depiler());
            }
            catch(PilePleineException ppe){
                return;
            }
            catch(PileVideException pve){
                return;
            }
            toggleButtons();
        }
    }
    
    class SubListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.empiler(pile.depiler()-pile.depiler());
            }
            catch(PilePleineException ppe){
                return;
            }
            catch(PileVideException pve){
                return;
            }
            toggleButtons();
        }
    
        
    }
    
    class MulListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.empiler(pile.depiler()*pile.depiler());
            }
            catch(PilePleineException ppe){
                return;
            }
            catch(PileVideException pve){
                return;
            }
            toggleButtons();
        }
    
        
    }
    
    class DivListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.empiler(pile.depiler()/pile.depiler());
            }
            catch(PilePleineException ppe){
                return;
            }
            catch(PileVideException pve){
                return;
            }
            catch(ArithmeticException ae){
                return;
            }
            toggleButtons();
        }
    
        
    }
    
    class ClearListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.reset();
            }catch(PileVideException pve){
                return;
            }
        } 
    }
    public void toggleButtons() //active ou desactive les boutons des operateurs selon la taille de la pile
    {
        if(pile.taille() > 1)
        {
            add.setEnabled(true);
            sub.setEnabled(true);
            mul.setEnabled(true);
            div.setEnabled(true);
        }
        else
        {
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        }
        donnee.requestFocus();
    }
}



