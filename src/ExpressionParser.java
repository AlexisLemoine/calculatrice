import java.util.ArrayList;
import java.util.Stack;


public class ExpressionParser {

    // ajoute les derniers opérateurs a sortie
    private void restes(Stack<Character>operateurs, ArrayList<String> sortie){
        while(!operateurs.empty()){
            sortie.add(Character.toString(operateurs.pop()));
        }
    }

    // teste si l expression courante est vide, sinon la deplace vers sortie
    private String testCourantVide (String courant, ArrayList<String> sortie){
        if (courant.length() != 0){
            sortie.add(courant);
            return "";
        }
        return courant;
    }
    
    // teste si un caractère est un operateur ou non
    private boolean testOperateur(char c){
        return ((c == '+')||(c == '-')||(c == '*')||(c == '/'));
    }

    // gestion si le caractère est plus ou moins ou pas
    private void gestionPriorité(char C, Stack<Character> operateurs, ArrayList<String> sortie){
        if ((C == '+')||(C == '-')){
            while(!operateurs.empty()){
                sortie.add(Character.toString(operateurs.pop()));
            }
            operateurs.push(C);
            }
        else {
            if (!operateurs.empty()){
                while (operateurs.peek() == '+' || operateurs.peek() == '-'){
                    sortie.add(Character.toString(operateurs.pop()));
                }
                operateurs.push(C);
            }
            else {System.out.println("Message d erreur.");}
        }
    }

    // gere l ajout de l operateur
    private String gestionOperateur(char C, Stack<Character> operateurs, ArrayList<String> sortie, String courant){
        if (operateurs.empty()){
            operateurs.push(C);
        }
        else {
            gestionPriorité(C, operateurs, sortie);
        }
        courant = testCourantVide(courant, sortie);
        return courant;
    }

    // calcule la notation polonaise inversée de l'expression 
    public ArrayList<String> convertir(String expression){
        // une pile pour les operateurs 
        Stack<Character> operateurs = new Stack<>();

        // une liste pour la notation polonaise a renvoyer 
        ArrayList<String> sortie = new ArrayList<>();

        String courant = "";

        for (int i = 0; i < expression.length(); i++){
            char C = expression.charAt(i);
            if (testOperateur(C)){
                courant = gestionOperateur(C, operateurs, sortie, courant);
            }
            else {
                courant += C;
            }
        }  

        courant = testCourantVide(courant, sortie);

        restes(operateurs, sortie);

        return sortie;
    }

}
