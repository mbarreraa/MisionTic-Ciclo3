/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.mt.ciclo3.boat.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    @Column(name = "message_text", length = 250)
    private String messageText;
    @JoinColumn(name = "boat_id", referencedColumnName = "id")
    @ManyToOne
    private Boat boatId;
    @JoinColumn(name = "client_id", referencedColumnName = "id_client", nullable = false)
    @ManyToOne(optional = false)
    private Client clientId;
     */
    @Id
    @Basic(optional = false)
    @Column(name = "id_message")
    private Integer idMessage;
    @Column(name = "message_text")
    private String messageText;
    @JoinColumn(name = "boat_id", referencedColumnName = "id")
    @ManyToOne
    private Boat boatId;
    @JoinColumn(name = "client_id", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client clientId;
}
