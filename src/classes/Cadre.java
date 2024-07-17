package classes;

import java.util.HashSet;
import java.util.Set;

public class Cadre extends Employe {
    Set<Employe> subordonnes=new HashSet<>();

    public Cadre(String nom, Sexe sexe, Cadre superieur) throws Exception {
        super(nom, sexe,superieur);
    }
    public Cadre(String nom, Sexe sexe) {
        super(nom,sexe);
    }

    @Override
    public String getNom() {
        String nom = super.getNom();

        if (getSexe()== Sexe.Homme) {
            return "Mr." + nom;
        } else  {
            return "Mme " + nom;
        }
    }

    @Override
    public Cadre getSuperieur() {
        return super.getSuperieur();
    }

    public void ajouteSubordonne(Employe e) //throws Exception
    {
        /*if (subordonneExisteDeja(e)) {
            throw new Exception("Cet employé est déjà au service de ce cadre.");
        }*/
      boolean test;
      test=subordonnes.add(e);
      if(test==true){
          System.out.println("Employé ajouté au service avec succès");
      }
          else  System.out.println("Cet employé est déjà au service de ce cadre.");
    }
    private boolean subordonneExisteDeja(Employe e) {
        for (Employe existant : subordonnes) {
            if (existant.getNom().equals(e.getNom())) {
                return true;
            }
        }
        return false;
    }
    public void afficheSubordonnes(){
        for(Employe e:subordonnes){
            System.out.println(e.toString());
        }
    }

    @Override
    public String toString() {
       String s=" =====================\n"+ "cadre : "+getNom()+"\n";
        for(Employe e:subordonnes)
            s=s+ "\n"+e.toString();
        s=s+" \n=====================\n";
        return s;
    }

    @Override
    public double getSalaire() {
        double salaireTotal = super.getSalaire();
        for(Employe e:subordonnes){
            salaireTotal+=e.getSalaire()*0.4;
        }
        return salaireTotal;
    }
    public void removeSubordonne(Employe e){
        subordonnes.remove(e);
    }
    public void affichageServiceRecursif(){
        for(Employe e:subordonnes){
            System.out.println(e.toString() + " - Salaire : " + e.getSalaire());
            if(e instanceof Cadre) {
                ((Cadre) e).affichageServiceRecursif();
            }
        }
    }
    public void afficheService(){
        System.out.println("Service de "+getNom()+":");
        affichageServiceRecursif();
    }
}

