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
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "description", length = 250)
    private String description;
    
    @OneToMany(mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Boat> boats;
}
