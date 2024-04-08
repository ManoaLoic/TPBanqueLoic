package tp.banque.tpbanqueloic.service;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import tp.banque.tpbanqueloic.entity.CompteBancaire;

/**
 *
 * @author Manoa Loic
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root",
        password = "root",
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true",
            "driverClass=com.mysql.cj.jdbc.Driver"
        }
)
@Dependent
public class GestionnaireCompte {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    @Transactional
    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }

//    public CompteBancaire findById(int idCompte) {
//        return em.find(CompteBancaire.class, idCompte);
//    }
    public List<CompteBancaire> getAllComptes() {
        String s = "select c from CompteBancaire as c";
        TypedQuery<CompteBancaire> query
                = em.createQuery(s, CompteBancaire.class);
        return query.getResultList();
    }

//    @Transactional
//    public CompteBancaire update(CompteBancaire compte) {
//        return em.merge(compte);
//    }
}
