package br.edu.utfpr.e_station.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    protected UUID id = UUID.randomUUID();

    @Column(name = "createDate", length = 200, nullable = false)
    protected LocalDateTime createDate;
    @Column(name = "updateDate", length = 200, nullable = false)
    protected LocalDateTime updateDate;

    @PrePersist
    public void prePersist() {
        // Definir a data de criação automaticamente antes de persistir a entidade
        if (createDate == null) {
            createDate = LocalDateTime.now();
        }

        if (updateDate == null) {
            updateDate = LocalDateTime.now(); // Preenchendo o updateDate
        }
    }

}
