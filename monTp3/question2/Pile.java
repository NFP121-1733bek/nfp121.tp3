package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
        if(taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        zone = new Object[taille];
        this.ptr = 0;
         
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if(estPleine())
            throw new PilePleineException();
        this.zone[this.ptr++] = o;
        
    }

    public Object depiler() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        return this.zone[--this.ptr];
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        return this.zone[this.ptr - 1];
    }

    public int capacite() {
        // a completer
        return this.zone.length;
    }

    public int taille() {
        // a completer
        return this.ptr;
    }

    public boolean estVide() {
        // a completer
        return this.taille() == 0;
    }

    public boolean estPleine() {
        // a completer
        return this.taille() == this.capacite();
    }

    public boolean equals(Object o) {
        // a completer
        
        if(o instanceof Pile){
            Pile temp;
            temp = (Pile)o;
                
            if (this.capacite() != temp.capacite() || this.taille() != temp.taille())
                return false;
            
            for(int i =0;i < this.taille();i++){
                if(!this.zone[i].equals(temp.zone[i]))
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

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}