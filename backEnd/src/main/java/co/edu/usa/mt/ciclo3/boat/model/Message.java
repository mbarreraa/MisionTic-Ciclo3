/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.mt.ciclo3.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Message implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_message")
    private Integer idMessage;
    @Column(name = "message_text", length = 250)
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name = "boat_id", referencedColumnName = "id")
    @JsonIgnoreProperties("messages")
    private Boat boat;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id_client")
    @JsonIgnoreProperties("messages")
    private Client client;
}
