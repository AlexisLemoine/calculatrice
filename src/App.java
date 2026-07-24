import javax.swing.JTextArea;

public class App {

    // créér un bouton sur la calculatrice
    public static void bouton(String touche, int x, int y, int a, int b, Interface I, JTextArea texte){
        Bouton B = new Bouton(touche);
        B.ajoutBouton(x,y,a,b,I.fenêtre);
        B.ajoutAction(touche, texte);
    }

    // ajouter tous les boutons à la calculatrice
    public static void creerBouton(Interface I, JTextArea text){
        // première ligne 
        bouton ("1",20,100,60,50,I,text);
        bouton ("2",80,100,60,50,I,text);
        bouton ("3",140,100,60,50,I,text);
        bouton ("+",200,100,60,50,I,text);

        // deuxième ligne
        bouton ("4",20,150,60,50,I,text);
        bouton ("5",80,150,60,50,I,text);
        bouton ("6",140,150,60,50,I,text);
        bouton ("-",200,150,60,50,I,text);

        // troisième ligne
        bouton ("7",20,200,60,50,I,text);
        bouton ("8",80,200,60,50,I,text);
        bouton ("9",140,200,60,50,I,text);
        bouton ("*",200,200,60,50,I,text);

        // quatrième ligne
        bouton ("/",20,250,60,50,I,text);
        bouton ("0",80,250,60,50,I,text);
        bouton (".",140,250,60,50,I,text);
        bouton ("=",200,250,60,50,I,text);
        
        I.fenêtre.revalidate();
        I.fenêtre.repaint();
        }

    public static void main(String[] args) throws Exception {

        // Création de l'ecran avec l'interface, une autre classe
        Interface inter = new Interface(); 

        final JTextArea textArea = new JTextArea();

        // choix de la taille de la fenêtre
        textArea.setBounds(20,50, 200,25);
        int hauteur = 350;
        int largeur = 290;
        inter.taille(largeur, hauteur); 

        // ajout d'un titre
        String titre = "Ma Calculatrice";
        inter.title(titre); 

        // choix de la position de la fenêtre sur l'écran
        inter.Localisation(600,260);
        inter.fenêtre.add(textArea);

        // Création des boutons
        creerBouton(inter, textArea);

        // Boucle pour que la fenêtre reste ouverte
        inter.fenêtre.setVisible(true);
    }
}
