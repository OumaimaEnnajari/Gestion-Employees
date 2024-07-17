package test;
import classes.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Cadre cd2=new Cadre("Lewis Peter", Sexe.Homme);
       Employe e1=new Employe("Lewandowski Robert", Sexe.Homme,cd2);
        Employe e2=new Employe("Lewandowski test", Sexe.Homme,cd2);
        Cadre cd3=new Cadre("test 123", Sexe.Homme,cd2);
        Employe e3=new Employe("Employé test", Sexe.Homme,cd3);
        System.out.println(cd2);
        System.out.println("=======================================");
        cd2.afficheSubordonnes();
    }
}
