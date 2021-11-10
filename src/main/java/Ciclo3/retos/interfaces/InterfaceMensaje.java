/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.retos.interfaces;

import Ciclo3.retos.model.Mensaje;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author FAMILIA
 */
public interface InterfaceMensaje extends CrudRepository<Mensaje, Integer>{
    
}
