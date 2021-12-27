/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entities.Status;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author julia
 * 
 * classe referente ao sistema de acesso ao banco de dados
 */
@Stateless
public class statusFacade extends AbstractFacade<Status> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public statusFacade() {
        super(Status.class);
    }
    
}
