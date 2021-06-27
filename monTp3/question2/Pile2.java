package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        // prevoir le cas <=0
        // a completer
        if(taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.capacite = taille;
        this.stk = new Stack<Object>();
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if(estPleine())
            throw new PilePleineException();
        this.stk.push(o);
    }

    public Object depiler() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        return this.stk.peek();
            
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
        return this.taille() == 0;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // a completer
        
        return this.taille() == this.capacite();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        // a completer
        for (int i = this.taille() - 1; i >= 0; i--) {
            s += this.stk.elementAt(i).toString();
            if (i > 0)
                s += ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        // a completer
        if(o instanceof Pile2){
            Pile2 temp;
            temp = (Pile2)o;
                
            if (this.capacite() != temp.capacite() || this.taille() != temp.taille())
                return false;
            
            for(int i =0;i < this.taille();i++){
                if(!this.stk.elementAt(i).equals(temp.stk.elementAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
        return this.stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        return this.capacite;
    }

} // Pile2.java
