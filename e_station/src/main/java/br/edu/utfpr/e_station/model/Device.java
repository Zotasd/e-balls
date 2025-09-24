package br.edu.utfpr.e_station.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_devices")
@Data
public class Device extends BaseEntity {

    @Column(name = "model", length = 200, nullable = false)
    private String model;

    @Column(name = "location", length = 200, nullable = false)
    private String location;

    @ManyToOne
    private Property property;

    @OneToMany(mappedBy = "device")
    private List<Sensor> sensores = new ArrayList<>();
}
