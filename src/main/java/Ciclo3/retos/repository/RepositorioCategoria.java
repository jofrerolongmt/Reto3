/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.retos.repository;

import Ciclo3.retos.interfaces.InterfaceCategoria;
import Ciclo3.retos.model.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAMILIA
 */
@Repository
public class RepositorioCategoria {
            @Autowired
	    private InterfaceCategoria crud;
	    public List<Categoria> getAll(){
	        return (List<Categoria>) crud.findAll();
	    }
	    public Optional<Categoria> getCategoria(int id){
	        return crud.findById(id);
	    }
	
	    public Categoria save(Categoria Categoria){
	        return crud.save(Categoria);
	    }
	    public void delete(Categoria Categoria){
	       crud.delete(Categoria);
	    }
    
}
