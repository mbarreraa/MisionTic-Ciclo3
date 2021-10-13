/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.mt.ciclo3.boat.model;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Client {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    @Column(name = "age")
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<Reservation> reservations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<Message> messages;
*/
    @Id
    @Basic(optional = false)
    @Column(name = "id_client")
    private Integer idClient;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<Reservation> reservationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<Message> messageList;

}
