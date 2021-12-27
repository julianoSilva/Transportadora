/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author julia
 * 
 * objeto represantando a tabela do sistema
 * tabela composta pelos estados de um objeto postado
 * o objeto é identificado pela coluna ident (abreviado de identificador)
 * 
 */
@Entity
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    // id geral da tabela
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // mensagem do status
    private String message;
    // identificador do objeto
    private Long ident;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // get do Identificador do objeto
    public Long getOrder() {
        return ident;
    }

    //set do identificador do objeto
    public void setOrder(Long ident) {
        this.ident = ident;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.status[ id=" + id + " ]";
    }
    
}
