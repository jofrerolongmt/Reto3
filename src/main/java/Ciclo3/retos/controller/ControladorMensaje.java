/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.retos.controller;
import Ciclo3.retos.service.ServiciosMensaje;
import Ciclo3.retos.model.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorMensaje {
     @Autowired
    private ServiciosMensaje servico;
    @GetMapping("/all")
    public List<Mensaje> getMessages(){
        return servico.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje> getMessage(@PathVariable("id") int idMessage) {
        return servico.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje message) {
        return servico.save(message);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje message) {
        return servico.update(message);
    }

    @DeleteMapping("/{idMessage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idMessage") int idMessage) {

        return servico.deleteMessage(idMessage);
    }
    
}
