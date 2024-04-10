/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package tp.banque.tpbanqueloic.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.PositiveOrZero;
import tp.banque.tpbanqueloic.entity.CompteBancaire;
import tp.banque.tpbanqueloic.jsf.util.Util;
import tp.banque.tpbanqueloic.service.GestionnaireCompte;

/**
 *
 * @author Manoa Loic
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    String nom;

    @PositiveOrZero
    Integer solde;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public String doCreate() {
        CompteBancaire c = new CompteBancaire(nom, solde);
        gestionnaireCompte.creerCompte(c);
        Util.addFlashInfoMessage("Compte de " + c.getNom() + " créé avec succès");
        return "listeComptes?faces-redirect=true";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

}
