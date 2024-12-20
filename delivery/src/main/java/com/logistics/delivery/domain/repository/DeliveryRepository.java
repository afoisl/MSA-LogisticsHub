package com.logistics.delivery.domain.repository;

import com.logistics.delivery.application.dto.SearchParameter;
import com.logistics.delivery.domain.model.Delivery;
import com.logistics.delivery.domain.model.DeliveryStatus;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryRepository {

    Optional<Delivery> findById(UUID id);

    boolean existsByOrderId(UUID orderId);

    List<Delivery> findAll();

    Delivery save(Delivery delivery);

    void deleteById(UUID id);

    List<Delivery> findActiveDeliveriesByDestinationHubId(UUID destinationHubId, List<DeliveryStatus> statusList);

    List<Delivery> findUnassignedDeliveries();

    Page<Delivery> searchDeliveries(SearchParameter searchParameter);

    List<Delivery> findAllByStatusNotIn(List<DeliveryStatus> statusList);
}
