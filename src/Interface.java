import javax.swing.JFrame;

public class Interface {
    JFrame fenêtre;
    int hauteur;
    int largeur;
    String titre;
    int localX;
    int localY;

    // Constructeur
    Interface(){
        fenêtre = new JFrame();  
        fenêtre.setVisible(true);
    }

    // Dimensions 
    public void taille(int x, int y){
        hauteur = x;
        largeur = y;
        fenêtre.setSize(x, y);    
    }

    // Titre
    public void title(String T){
        titre = T;
        fenêtre.setTitle(T);
    }
    
    // Localisation
    public void Localisation(int x, int y){
        localX = x;
        localY = y;
        fenêtre.setLocation(x, y);
    }
}
