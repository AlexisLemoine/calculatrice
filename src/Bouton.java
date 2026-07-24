import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Bouton{
    JButton btn;
    String Nom;
    private static String CH = "";

    // Constructeur
    Bouton(String N){
        Nom = N;
        btn = new JButton(Nom);
    }

    // Ajouter le bouton à l'écran aux coordonnées indiquées et à la taille souhaitée
    public void ajoutBouton(int x, int y, int a, int b, JFrame I){
        btn.setBounds(x, y, a, b);
        I.add(btn);
        I.setLayout(null);
    }

    // fait le calcul pour l'opérateur '='
    private String calculer(String text){
        ExpressionParser E = new ExpressionParser();
        // Boolean correct = testExpression(text);

        ArrayList<String> polonaiseInverse = E.convertir(text);
        String res = "";
        for (int i = 0; i < polonaiseInverse.size(); i++){
            res += polonaiseInverse.get(i);
        }
        return res;
    }

    // ajoute le nouveau caractère a la chaîne en cours
    public void ajoutAction(String ajout, JTextArea textArea){

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                // On convertit en String avant de faire des calculs 
                String calcul = textArea.getText();
                
                // la comparaison de String se fait avec equals
                if (!ajout.equals("=")){
                    CH += ajout;
                }
                else{CH = calculer(calcul);}
                textArea.setText(CH);
            }
        });
    }

    // met à jour l'affichage
    public void setTextArea(JTextArea textArea) {
        btn.addActionListener(e -> textArea.setText(CH.trim())); // Met à jour l'affichage
    }

}