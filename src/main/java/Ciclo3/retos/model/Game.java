/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.retos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *Tabla Game Retos Ciclo 3
 */
@Entity
@Table(name = "game")
public class Game implements Serializable {
    /**
     *Modelo de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String developer;
    private Integer year;
    private String description;
    /**
     *Relacion con categoria
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("games")
    private Categoria category;
    /**
     *Relacion con message
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "game")
    @JsonIgnoreProperties({"game", "client"})
    private List<Mensaje> messages;
    /**
     * relacion con reservacione
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "game")
    @JsonIgnoreProperties({"game", "client"})
    private List<Reservaciones> reservations;

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDeveloper() {
        return developer;
    }

    /**
     *
     * @param developer
     */
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    /**
     *
     * @return
     */
    public Integer getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public Categoria getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /**
     *
     * @return
     */
    public List<Mensaje> getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    /**
     *
     * @param reservations
     */
    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }


}

    
