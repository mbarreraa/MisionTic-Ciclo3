/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.mt.ciclo3.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Reservation implements Serializable {

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
    @Column(name = "status", length = 20)
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "boat_id", referencedColumnName = "id")
    @JsonIgnoreProperties("reservations")
    private Boat boat;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id_client")
    @JsonIgnoreProperties("reservations")
    private Client client;
    
    @OneToOne
    @JsonIgnoreProperties("reservation")
    private Score score;

}
