/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package tp.banque.tpbanqueloic.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import tp.banque.tpbanqueloic.entity.CompteBancaire;
import tp.banque.tpbanqueloic.jsf.util.Util;
import tp.banque.tpbanqueloic.service.GestionnaireCompte;

/**
 *
 * @author Manoa Loic
 */
@Named(value = "renommer")
@ViewScoped
public class Renommer implements Serializable {

    private Long id;
    private CompteBancaire compte;
    private String ancienNom;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public String renommerCompte(){
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Nom " + ancienNom + " changé en " + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }
    
    public void loadCompte() {
        compte = gestionnaireCompte.findById(id);
        ancienNom = compte.getNom();
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

}
