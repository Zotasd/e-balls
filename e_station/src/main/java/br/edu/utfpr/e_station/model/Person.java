package br.edu.utfpr.e_station.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_person")
@Data
public class Person extends BaseEntity {

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "phone", length = 200, nullable = false)
    private String phone;

}
