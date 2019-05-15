/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gns;

/**
 *
 * @author etudiant
 */
public class Joueur {
    private String nom;
    private String mdp;
    private String genre;
    private String pays;
    private boolean cgu;
    
    public Joueur (String nom,String mdp, String genre,String pays, boolean cgu){
        this.cgu=cgu;
        this.genre=genre;
        this.mdp=mdp;
        this.nom=nom;
        this.pays=pays;
        
    }
     public Joueur (String nom,String mdp, String genre, boolean cgu){
        this.cgu=cgu;
        this.genre=genre;
        this.mdp=mdp;
        this.nom=nom;
       
        
    }
    public Joueur (String nom,String mdp){
        this.cgu=cgu;
        this.genre=genre;
     
    }

    @Override
    public String toString() {
        return "Joueur{" + "nom=" + nom + ", mdp=" + mdp + ", genre=" + genre + ", pays=" + pays + ", cgu=" + cgu + '}';
    }

    
}
