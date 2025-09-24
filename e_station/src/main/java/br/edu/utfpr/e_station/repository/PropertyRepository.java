package br.edu.utfpr.e_station.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.utfpr.e_station.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {
    Page<Property> findById(UUID propertyId, Pageable pageable);

    Page<Property> findAllByOwnerId(UUID ownerId, Pageable pageable);

}
