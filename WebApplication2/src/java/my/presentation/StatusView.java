/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package my.presentation;

import boundary.statusFacade;
import entities.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author julia
 * 
 * classe de controle do sistema de funcionamento do site
 * principal classe referente ao funcionamento lógico
 */
@Named(value = "statusView")
@RequestScoped
public class StatusView {

    @EJB
    private statusFacade statusFacade;

    //objeto usado para captura de dados
    private Status st;

    //lista utilizada para gerar o conteúdo de uma pesquisa por um objeto
    private List<Status> sts;
    
    //marcador de qual objeto está sendo buscado
    private long idToList;

    public Status getSt() {
        return st;
    }
    
    //retorna uma lista no formato de Array para ser percorrida e dar display no 
    // frontend
    public Status[] getArray(){
        return sts.toArray(new Status[sts.size()]);
    }
    
    // volta o total de tuplas na tabela (usado para debug)
    public int getStatusCount(){
        return statusFacade.findAll().size();
    }
    
    // adiciona nova tupla na tabela
    public String postAddStatus(){
        statusFacade.create(st);
        return "addedStatus";
    }
    
    // post referente ao acesso da pagina newStatus
    public String postPointToAdd(){
        return "newStatus";
    }
    
    // post referente ao acesso da lista de estados de um objeto
    // também é responsavel por buscar no banco de dados as informações
    public String postStatusList(){
        idToList = st.getOrder();
        sts.clear();
        for(Status s: statusFacade.findAll()){
            
            if(s.getOrder() == idToList){
                sts.add(s);
            }
        }
        return "list";
    }
    
    // post de retorno ao inicio do site
    public String postIndex(){
        return "index";
    }
    
    /**
     * construtor do objeto
     */
    public StatusView() {
        st = new Status();
        sts = new ArrayList<Status>();
    }
    
}
