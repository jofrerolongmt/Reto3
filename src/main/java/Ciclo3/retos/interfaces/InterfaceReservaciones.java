/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.retos.interfaces;

import Ciclo3.retos.model.Reservaciones;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author FAMILIA
 */

    
    public interface InterfaceReservaciones extends CrudRepository <Reservaciones,Integer>{
    public List<Reservaciones> findAllByStatus(String status);
    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore (Date dateOne,Date dateTwo);
    @Query("SELECT c.client, COUNT(c.client) FROM Reservaciones AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]>   countTotalReservationByClient ();
}