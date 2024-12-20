package com.logistics.delivery.domain.service;

import com.logistics.delivery.application.dto.delivery.DeliveryRouteResponse;
import com.logistics.delivery.application.dto.delivery.RouteStatusUpdateRequest;
import com.logistics.delivery.domain.model.Delivery;
import com.logistics.delivery.domain.model.DeliveryRoute;

import java.util.List;
import java.util.UUID;

public interface DeliveryRouteService {

    void createRoutesForDelivery(Delivery delivery);

    List<DeliveryRoute> getRoutesByDeliveryId(UUID deliveryId);

    void deleteByDeliveryId(UUID id);

    DeliveryRouteResponse updateRouteStatus(UUID routeId, RouteStatusUpdateRequest request);
}
