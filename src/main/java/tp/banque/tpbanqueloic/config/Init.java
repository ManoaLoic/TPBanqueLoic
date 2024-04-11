/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.banque.tpbanqueloic.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import java.util.List;
import tp.banque.tpbanqueloic.entity.CompteBancaire;
import tp.banque.tpbanqueloic.service.GestionnaireCompte;

import java.util.logging.Logger;

/**
 *
 * @author Manoa Loic
 */
@ApplicationScoped
public class Init {

    private final static Logger logger = Logger.getLogger("tp.banque.tpbanqueloic.config.Init");
    
    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public void onStartup(@Observes @Initialized(ApplicationScoped.class) ServletContext context) {
        List<CompteBancaire> comptes = gestionnaireCompte.getAllComptes();
        if (comptes.isEmpty()) {
            logger.warning("Aucun compte dans la base de données. Création de comptes");
            gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }else{
            logger.info("La base de données n'est pas vide");
        }
    }
}
