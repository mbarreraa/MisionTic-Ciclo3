/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.mt.ciclo3.boat.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    @Column(name = "startDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "devolutionDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date devolutionDate;
    @Column(name = "status", nullable = false, length = 20)
    private String status;
    @JoinColumn(name = "boat_id", referencedColumnName = "id")
    @ManyToOne
    private Boat boatId;
    @JoinColumn(name = "client_id", referencedColumnName = "id_client", nullable = false)
    @ManyToOne(optional = false)
    private Client clientId;
     */
    @Id
    @Basic(optional = false)
    @Column(name = "idReservation")
    private Integer idReservation;
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "devolutionDate")
    @Temporal(TemporalType.DATE)
    private Date devolutionDate;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "boat_id", referencedColumnName = "id")
    @ManyToOne
    private Boat boatId;
    @JoinColumn(name = "client_id", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client clientId;
}
