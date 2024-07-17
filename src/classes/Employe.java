package classes;

public class Employe {
    private Sexe sexe;
    private String nom;
    private Cadre superieur;
    protected Employe(String nom,Sexe sexe) {
        this.sexe = sexe;
        this.nom = nom;
    }
    public Employe(String nom,Sexe sexe, Cadre superieur) throws Exception
    {
        this.sexe = sexe;
        this.nom = nom;
        if(superieur==null) throw new Exception("l'employé pas peut etre construit sans supérieur");
        superieur.ajouteSubordonne(this);
        this.superieur=superieur;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Cadre getSuperieur() {
        return superieur;
    }

    @Override
    public String toString() {
        String politesse = (getSexe() == Sexe.Homme) ? "M." : "Mme.";
        String description = getNom();
        return description;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employe employe = (Employe) obj;
        return getNom().equals(employe.getNom()) && getSexe() == employe.getSexe();
    }

    public double getSalaire(){
        return 1430.22;
    }

    public boolean aPourSuperieur(Employe e){
        if(e.superieur==null) return  false;
        if(superieur.equals(e)){
            return true;
        }
        return e.aPourSuperieur(e);
    }
    public void changementAffectation(Cadre c) throws Exception {
        if(aPourSuperieur(c)){
            System.out.println("Changement d'affectation interdit.");
        }else{
            if(superieur!=null) superieur.removeSubordonne(this);
        }
        superieur=c;
        c.ajouteSubordonne(this);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
