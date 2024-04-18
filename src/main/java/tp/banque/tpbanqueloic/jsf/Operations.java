/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package tp.banque.tpbanqueloic.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;
import tp.banque.tpbanqueloic.entity.CompteBancaire;
import tp.banque.tpbanqueloic.entity.OperationBancaire;
import tp.banque.tpbanqueloic.service.GestionnaireCompte;

/**
 *
 * @author Manoa Loic
 */
@Named(value = "operations")
@RequestScoped
public class Operations {

    private Long id;
    private CompteBancaire compte;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public List<OperationBancaire> getOperations(){
        return compte != null ? compte.getOperations() : null;
    }
    
    public void loadCompte() {
        compte = gestionnaireCompte.findById(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

}
