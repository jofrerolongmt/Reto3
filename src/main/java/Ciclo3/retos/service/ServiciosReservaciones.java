/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.retos.service;

import Ciclo3.retos.model.Reservaciones;
import Ciclo3.retos.reports.CountClient;
import Ciclo3.retos.reports.ReservationStatus;
import Ciclo3.retos.repository.RepositorioReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Esta clase es el servicio de Reservation
 */
@Service
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;

    /**
     * Este metodo obtiene toda la lista de Reservaciones
     *
     * @return
     */

    public List<Reservaciones> getAll() {
        return metodosCrud.getAll();
    }

    /**
     * Este metodo obtiene una reservacion por id
     *
     * @param reservationId
     * @return
     */

    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    /**
     * Este metodo guarda una reservacion
     *
     * @param reservation
     * @return
     */

    public Reservaciones save(Reservaciones reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservaciones> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * Este metodo actualiza una reservacion
     *
     * @param reservation
     * @return
     */

    public Reservaciones update(Reservaciones reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservaciones> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                if (reservation.getClient() != null) {
                    e.get().setClient(reservation.getClient());
                }
                if (reservation.getGame() != null) {
                    e.get().setGame(reservation.getGame());
                }

                metodosCrud.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * Este metodo elimina una reservacion
     *
     * @param reservationId
     * @return
     */

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Este metodo obtiene el estado de la reservacion
     *
     * @return
     */
    public ReservationStatus getReservationStatusReport() {
        List<Reservaciones> completed = metodosCrud.getReservationByStatus("completed");
        List<Reservaciones> cancelled = metodosCrud.getReservationByStatus("cancelled");
        return new ReservationStatus(completed.size(), cancelled.size());
    }

    /**
     * Este metodo obtiene la fecha de la reservacion
     *
     * @param dateOne
     * @param dateTwo
     * @return
     */

    public List<Reservaciones> getReservationPeriod(String dateOne, String dateTwo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(dateOne);
            Date endDate = dateFormat.parse(dateTwo);
            if (startDate.before(endDate)) {
                return metodosCrud.getReservationPeriod(startDate, endDate);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<CountClient> getTopClients() {
        return metodosCrud.getTopClient();
    }
}