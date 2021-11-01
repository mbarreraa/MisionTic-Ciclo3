package co.edu.usa.mt.ciclo3.boat.service;

import co.edu.usa.mt.ciclo3.boat.model.Reservation;
import co.edu.usa.mt.ciclo3.boat.reports.CountClient;
import co.edu.usa.mt.ciclo3.boat.reports.ReservationStatus;
import co.edu.usa.mt.ciclo3.boat.repository.ReservationRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase ReservationService
 * @author Miguel Barrera
 */
@Service
public class ReservationService {

    @Autowired
    /**
     * Repositorio de reservas
     */
    private ReservationRepository reservationRepository;

    /**
     * Obtiene todas las reservas
     * @return lista de todas las reservas
     */
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    /**
     * Inserta un reserva
     * @param reservation
     * @return reserva almacenada
     */
    public Reservation save(Reservation reservation) {

        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> existent = reservationRepository.getById(reservation.getIdReservation());

            if (existent.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * Borra una reserva por su identificador
     * @param id identificador de la reserva a eliminar
     * @return true si se elimino correctamente, false si fallo la eliminacion
     */
    public boolean delete(int id) {
        Optional<Reservation> dbReservation = reservationRepository.getById(id);
        boolean exito = false;
        if (!dbReservation.isEmpty()) {
            reservationRepository.delete(dbReservation.get());
            exito = true;
        }
        return exito;
    }

    /**
     * Actualiza los datos de una reservas
     * @param reservation reserva a actualizar
     * @return reserva actualizada
     */
    public Reservation update(Reservation reservation) {

        if (reservation.getIdReservation() != null) {
            Optional<Reservation> dbReservation = reservationRepository.getById(reservation.getIdReservation());

            if (!dbReservation.isEmpty()) {
                if (reservation.getDevolutionDate() != null) {
                    dbReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStartDate() != null) {
                    dbReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getStatus() != null) {
                    dbReservation.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(dbReservation.get());
            } else {
                return reservation;
            }
        }
        return reservation;
    }

    /**
     * Obtiene una reserva por su identificador
     * @param id identificador de la reserva a buscar
     * @return reserva encontrada
     */
    public Optional<Reservation> getById(int id) {
        return reservationRepository.getById(id);
    }

    /**
     * Genera reporte de las reservas que se encuentran en estado completed y cancelled
     * @return informe de reservas
     */
    public ReservationStatus getReservationStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new ReservationStatus(completed.size(), cancelled.size());
    }

    /**
     * Obtiene las reservas en un periodo de tiempo
     * @param dateOne fecha incial
     * @param dateTwo fecha final
     * @return listado de reservas en el periodo de tiempo
     */
    public List<Reservation> getReservationPeriod(String dateOne, String dateTwo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(dateOne);
            Date endDate = sdf.parse(dateTwo);
            
            if (startDate.before(endDate)){
                System.out.println("Fechas bien, ingresa a consultar");
                return reservationRepository.getReservationPeriod(startDate, endDate);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    /**
     * Obtiene el top de clientes acorde con las reservas realizadas
     * @return top de clientes descendente con las reservas realizadas.
     */
    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }
}
