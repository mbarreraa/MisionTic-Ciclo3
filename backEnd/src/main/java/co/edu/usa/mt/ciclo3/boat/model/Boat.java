/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.mt.ciclo3.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "boat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boat implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(name = "brand", length = 45, nullable = false)
    private String brand;
    @Column(name = "year", length = 4)
    private Integer year;
    @Column(name = "description", length = 250, nullable = true)
    private String description;
    
    @OneToMany(mappedBy = "boat")
    @JsonIgnoreProperties("boat")
    private List<Reservation> reservations;
    
    @OneToMany(mappedBy = "boat")
    @JsonIgnoreProperties("boat")
    private List<Message> messages;
    
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnoreProperties("boats")
    private Category category;

}
