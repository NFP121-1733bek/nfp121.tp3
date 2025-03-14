package question2;

/**
 * Classe-test Pile2Test.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile2Test extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Constructeur de la classe-test Pile2Test
     */
    private PileI p1;
    private PileI p2;
    public Pile2Test() {
        
    }

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
        p1 = new question2.Pile2();
        p2 = new question2.Pile2(5);
    }

    /**
     * Supprime les engagements
     * 
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libérez ici les ressources engagées par setUp()
        p1 = null;
        p2 = null;
    }
    public void test_Pile_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
        assertEquals(5, p2.capacite());
    }

    public void test_Pile_estPleine() throws Exception {
        PileI p = new question2.Pile2(5);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());
        p.empiler(0);
        assertEquals(4, p.taille());
        p.empiler(-1);
        assertEquals(5, p.taille());
        
        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile_sommet() throws Exception {
        PileI p = new question2.Pile2(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }

    public void test_Pile_estVide() throws Exception {
        PileI p = new question2.Pile2(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile_toString() throws Exception {
        PileI pile1 = new question2.Pile2(4);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(1);
        assertEquals("toString incorrect ? ", "[1]", pile1.toString());
        pile1.empiler(2);
        assertEquals("toString incorrect ? ", "[2, 1]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4, 2, 1]", pile1.toString());
        pile1.empiler(6);
        assertEquals("toString incorrect ? ", "[6, 4, 2, 1]", pile1.toString());

    }

    public void test_Pile_TailleNegative() {
        PileI p = new question2.Pile2(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }

    public void test_Pile_equals() throws Exception {
        PileI P_1 = new question2.Pile2(4);
        PileI P_2 = new question2.Pile2(4);
        P_1.empiler(4);
        P_1.empiler(2);
        P_1.empiler(3);

        P_2.empiler(4);
        P_2.empiler(2);
        P_2.empiler(3);

        assertTrue("égalité de deux piles ? ", P_1.equals(P_2));
        assertTrue("égalité de deux piles ? ", P_2.equals(P_1));
        assertTrue("égalité de deux piles ? ", P_1.equals(P_1));

        P_2.empiler(0);
        assertFalse("égalité de deux piles ? ", P_1.equals(P_2));

    }

    /**
     * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
     * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
     * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
     * "Enregistrer une méthode de test".
     */

}
