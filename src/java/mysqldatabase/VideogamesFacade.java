/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldatabase;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eamonn Hannon
 */
@Stateless
public class VideogamesFacade extends AbstractFacade<Videogames> {

    @PersistenceContext(unitName = "CT5106Assignment4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VideogamesFacade() {
        super(Videogames.class);
    }
    
}
