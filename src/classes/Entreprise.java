package classes;

import java.util.HashSet;
import java.util.Set;

public class Entreprise {
    private Set<Employe> Employes;
    private String nomEntreprise;
    private Cadre patron;

    public Entreprise(String nomEntreprise, Cadre patron) {
        this.nomEntreprise = nomEntreprise;
        this.patron = patron;
        this.Employes = new HashSet<>();
        Employes.add(patron);
    }

    public void ajouteEmploye(Employe e) throws Exception{
        if(Employes.contains(e)) throw new Exception("L'employé est déjà dans l'entreprise.");
        Employes.add(e);
    }
    public void affiche() {
        System.out.println("Liste des employés de l'entreprise :");
        for (Employe e : Employes) {
            System.out.println(e.toString() + " - Salaire : " + e.getSalaire());
        }
    }
    public Employe recherecheParNom(String nom) throws Exception{
        for(Employe e:Employes){
            if(e.getNom().equals(nom)){
                return e;
            }
            if(e instanceof Cadre){
                if(e.getNom().contains("M")||e.getNom().contains("Mme")) return e;
            }
        }
        throw new Exception("Aucun employé trouvé avec le nom : " + nom);
    }
    public void retireEmploye(String nom) throws Exception{
        Employe employeARetirer=recherecheParNom(nom);
        if (employeARetirer instanceof Cadre) {
         for(Employe subordonne: patron.subordonnes){
             Employes.remove(subordonne);
         }
        }
         Employes.remove(employeARetirer);
        }
}
