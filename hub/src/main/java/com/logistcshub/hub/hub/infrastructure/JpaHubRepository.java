package com.logistcshub.hub.hub.infrastructure;

import com.logistcshub.hub.area.domain.model.Area;
import com.logistcshub.hub.hub.domain.mode.Hub;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHubRepository extends JpaRepository<Hub, UUID> {
    @Query("select h from Hub h join fetch h.area where h.id = :id and h.isDeleted is false")
    Optional<Hub> findByIdWithArea(UUID id);

    boolean existsByAreaAndAddress(Area area, String address);
}