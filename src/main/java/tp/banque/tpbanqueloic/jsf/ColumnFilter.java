/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package tp.banque.tpbanqueloic.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Locale;

/**
 *
 * @author Manoa Loic
 */
@Named(value = "columnFilter")
@ApplicationScoped
public class ColumnFilter {

    public boolean filterBySolde(Object solde, Object filterValue, Locale locale) {
        
        if (solde == null || filterValue == null) {
            return false;
        }

        try {
            Integer soldeInt = (Integer) solde;
            Integer filterValueInt = Integer.valueOf((String) filterValue);

            return soldeInt >= filterValueInt;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
