package Entities.Exo2;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CentreAere
{
    private String nomCentreAere;
    private ArrayList<Maison> lesMaisons;

    public CentreAere(String nomCentreAere)
    {
        this.nomCentreAere = nomCentreAere;
        lesMaisons = new ArrayList<>();
    }
    // Cette méthode permet d'ajouter une Maison dans le centre aéré
    // Cette méthode n'est pas à tester
    public void AjouterMaison(Maison uneMaison)
    {
        lesMaisons.add(uneMaison);
    }

    //Cette méthode permet d'ajouter un enfant, dans une maison, dans une chambre
    // Attention, l'ajout ne peut se faire que si la chambre ne possède pas déjà 2 enfants
    // Si l'ajout ne peut se faire, la méthode retourne false sinon elle retourne true.
    public boolean AjouterEnfant(Enfant unEnfant, Maison uneMaison, Chambre uneChambre)
    {
        // A compléter ici

        int count =0;
for (Enfant e :uneChambre.getLesEnfants()){
    count=count+1;
}
        if(count<2){
        return true;
        }
        else {return false;}
    }

    // Cette méthode permet de rechercher l'enfant passé en paramètre
    // L'enfant passé en paramètre peut se trouver dans n'importe quelle maison, n'importe quelle chambre du centre aéré
    // Si l'enfant est trouvé, la méthode renvoie l'objet maison dans laquelle il se trouve
    // Si l'enfant n'est pas trouvé, la méthode renvoie null;
    public Maison RechercherEnfant(Enfant unEnfant)
    {
        Maison maisonTrouvee = null;

        // A compléter ici
for (Maison m:lesMaisons){
    for (Chambre c:m.getLesChambres()){
        for (Enfant e: c.getLesEnfants()){
            if (unEnfant==e){
                m=maisonTrouvee;
            break;}}}}
        return maisonTrouvee;
    }

    // Cette méthode permet de calculer le taux de remplissage de la maison passée en paramètre
    // Le taux se détermine en fonction du nombre d'enfants total de toutes les chambres de la maison par rapport
    // au nombre total de places disponibles (nombre de chambres de la maison * 2)
    // Pour arrondir le taux à 2 chiffres après la virgule, on utilise la méthode Math.round()
    public double TauxRemplissageMaison(Maison uneMaison)
    {
        // A compléter ici
        int i=0;//le nombre de places occupées
        int j=0;//le nombre de place totale

            for (Chambre c:uneMaison.getLesChambres()){
                j=j+2;

                for (Enfant e: c.getLesEnfants()){
                    i=i++;}}
double res=(i/j)*100;
        res=Math.round(res*100)/100;
        return res;
    }

    // Cette méthode permet de calculer le taux de remplissage du centre aéré
    // Le taux se détermine en fonction du nombre d'enfants total de toutes les chambres par rapport
    // au nombre total de chambres (nombre de chambres du centre * 2)
    // Pour arrondir le taux à 2 chiffres après la virgule, on utilise la méthode Math.round()
    public double TauxRemplissageCentreAere()
    {
        // A compléter ici
        int i=0;//le nombre de places occupées
        int j=0;//le nombre de place totale
        for (Maison m:lesMaisons){
            for (Chambre c:m.getLesChambres()){
                j=j+2;

                for (Enfant e: c.getLesEnfants()){
                    i=i++;}}}
        double res=(i/j)*100;
        res=Math.round(res*100)/100;
        return res;
    }
}
