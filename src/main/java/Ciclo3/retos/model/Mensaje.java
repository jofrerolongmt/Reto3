/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.retos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
	@Table(name = "message")
	public class Mensaje implements Serializable {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idMessage;
	    private String messageText;
	    
	    @ManyToOne
	    @JoinColumn(name="idGame")
	    @JsonIgnoreProperties({"messages", "client", "reservations"})
	    private Game game;
	
	    @ManyToOne
	    @JoinColumn(name="idClient")
	    @JsonIgnoreProperties({"messages", "reservations", "client"})
	    private Cliente client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
	    
	}
