/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.mt.ciclo3.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author miguel
 */
@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_client")
    private Integer idClient;
    @Column(name = "email", length = 45)
    private String email;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    @Column(name = "age")
    private Integer age;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

}
