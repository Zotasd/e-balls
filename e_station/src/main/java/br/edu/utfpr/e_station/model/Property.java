package br.edu.utfpr.e_station.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_property")
@Data
public class Property extends BaseEntity {

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @ManyToOne
    private Person owner;

    @Column(name = "areaSize", length = 200, nullable = false)
    private float areaSize;

}
