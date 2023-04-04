package Tests;

import Entities.Exo2.CentreAere;
import Entities.Exo2.Chambre;
import Entities.Exo2.Enfant;
import Entities.Exo2.Maison;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CentreAereTest
{
    private Enfant enfant1;
    private Enfant enfant2;
    private Enfant enfant3;
    private Enfant enfant4;
    private Enfant enfant5;

    private Maison maison1;
    private Maison maison2;

    private Chambre chambre1;
    private Chambre chambre2;
    private Chambre chambre3;

    private CentreAere centreAere;

    @BeforeEach
    void setUp()
    {
        // 5 enfants
        enfant1 = new Enfant("Garnier","François");
        enfant2 = new Enfant("Fortin","François");
        enfant3 = new Enfant("Gand","Christophe");
        enfant4 = new Enfant("Cousineau","Sébastien");
        enfant5 = new Enfant("Annonier","Eric");

        // 2 maisons
        maison1 = new Maison("Maison rouge");
        maison2 = new Maison("Maison verte");

        // 3 chambres
        chambre1 = new Chambre("Chambre 1");
        chambre2 = new Chambre("Chambre 2");
        chambre3 = new Chambre("Chambre 3");

        // 1 centre
        centreAere = new CentreAere("Centre Tests");
        // On ajoute les chambres aux maisons
        maison1.AjouterChambre(chambre1);maison1.AjouterChambre(chambre2);
        maison2.AjouterChambre(chambre3);

        // On ajoute les maisons au centre
        centreAere.AjouterMaison(maison1);centreAere.AjouterMaison(maison2);

    }

    @Test
    void ajouterEnfant()
    {
        // On ajoute l'enfant 1 à la maison 1,chambre 1
        maison1.AjouterChambre(chambre1);
        chambre1.AjouterEnfant(enfant1);


        // On ajoute l'enfant 2 à la maison 1,chambre 1
        maison1.AjouterChambre(chambre1);
        chambre1.AjouterEnfant(enfant2);

        // On ajoute l'enfant 3 à la maison 1,chambre 1
        maison1.AjouterChambre(chambre1);
        chambre1.AjouterEnfant(enfant3);
        ArrayList<Enfant> expected= chambre1.getLesEnfants();
        ArrayList<Enfant> actual=new ArrayList<>();
        actual.add(enfant1);actual.add(enfant2);actual.add(enfant3);
        assertEquals(actual,expected);

    }

    @Test
    void rechercherEnfant()
    {
        maison1.AjouterChambre(chambre1);
        chambre1.AjouterEnfant(enfant1);
        // On trouve l'enfant : on testera avec le nom de la maison
        Maison expected=new Maison;
        Maison actual= new Maison;
        expected= rechercherEnfant(enfant1);
        actual=maison1;
        assertEquals(actual,expected);
        // On ne trouve pas l'enfant : on testera avec null

        expected= rechercherEnfant(enfant1);
        actual=maison1;
        rechercherEnfant(enfant2);
        assertEquals(actual,expected);
    }

    @Test
    void tauxRemplissageMaison()
    {
        // Cas n°1 : aucun enfant parmi toutes les chambres
        double expected= new double;
        double actual= new double;
        expected= centreAere.TauxRemplissageMaison(maison1);
        actual=0;
        assertEquals(actual,expected);
        // Cas n°2 : 1 seul enfant parmi toutes les chambres
        maison1.AjouterChambre(chambre1);
        chambre1.AjouterEnfant(enfant1);

        // Cas n°3 : 3 enfants parmi toutes les chambres
        chambre1.AjouterEnfant(enfant2);
        maison1.AjouterChambre(chambre2);
        chambre1.AjouterEnfant(enfant3);


        // Cas n°4 : toutes les chambres sont complètement occupées
        chambre1.AjouterEnfant(enfant4);
        maison2.AjouterChambre(chambre3);
        chambre1.AjouterEnfant(enfant5);
        chambre1.AjouterEnfant(enfant1);

    }

    @Test
    void tauxRemplissageCentreAere()
    {
        // Cas n°1 : aucun enfant parmi toutes les chambres
        double expected= new double;
        double actual= new double;
        expected= centreAere.TauxRemplissageMaison(maison1);
        actual=0;
        assertEquals(actual,expected);

        // Cas n°2 : 2 enfants parmi toutes les chambres
        maison1.AjouterChambre(chambre1);
        chambre1.AjouterEnfant(enfant1);
        chambre1.AjouterEnfant(enfant2);

        // Cas n°3 : 4 enfants parmi toutes les chambres
        maison1.AjouterChambre(chambre2);
        chambre1.AjouterEnfant(enfant3);
        maison2.AjouterChambre(chambre3);
        chambre1.AjouterEnfant(enfant4);
    }
}