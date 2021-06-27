package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
        if(taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        
        v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter
        if(estPleine())
            throw new PilePleineException();
        
        this.v.addElement(o);
        
    }

    public Object depiler() throws PileVideException {
        // à compléter
        if(estVide())
            throw new PileVideException();
        
        return this.v.remove(this.taille() - 1);
    }

    public Object sommet() throws PileVideException {
        // à compléter
        return this.v.lastElement();
    }

    public int taille() {
        // à compléter
        return this.v.size();
    }

    public int capacite() {
        // à compléter
        return this.v.capacity();
    }

    public boolean estVide() {
        // à compléter
        return this.taille() == 0;
    }

    public boolean estPleine() {
        // à compléter
        return this.taille() == this.capacite();
    }

    public String toString() {
        // à compléter
         String s = "[";
        // a completer
        for (int i = this.taille() - 1; i >= 0; i--) {
            s += this.v.elementAt(i).toString();
            if (i > 0)
                s += ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        // à compléter
        if(o instanceof Pile3){
            Pile3 temp;
            temp = (Pile3)o;
                
            if (this.capacite() != temp.capacite() || this.taille() != temp.taille())
                return false;
            
            for(int i =0;i < this.taille();i++){
                if(!this.v.elementAt(i).equals(temp.v.elementAt(i)))
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

}
