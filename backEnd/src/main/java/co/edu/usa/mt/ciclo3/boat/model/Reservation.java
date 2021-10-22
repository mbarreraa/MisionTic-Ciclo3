/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.mt.ciclo3.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Integer idReservation;
    @Column(name = "startDate")
    //@Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "devolutionDate")
    //@Temporal(TemporalType.DATE)
    private Date devolutionDate;
    @Column(name = "status", length = 20)
    private String status = "created";
    
    @ManyToOne
    @JoinColumn(name = "boatId")
    @JsonIgnoreProperties("reservations")
    private Boat boat;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;
    
    @OneToOne(cascade = {CascadeType.REMOVE}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;

}
