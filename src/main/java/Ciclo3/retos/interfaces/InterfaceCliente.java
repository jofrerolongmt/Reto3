/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.retos.interfaces;

import Ciclo3.retos.model.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author FAMILIA
 */
public interface InterfaceCliente extends CrudRepository<Cliente, Integer>{
    
}
