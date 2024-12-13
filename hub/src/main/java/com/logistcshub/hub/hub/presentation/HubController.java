package com.logistcshub.hub.hub.presentation;

import static com.logistcshub.hub.common.domain.model.type.ResponseMessage.SUCCESS_CREATE_HUB;
import static com.logistcshub.hub.common.domain.model.type.ResponseMessage.SUCCESS_DELETE_HUB;
import static com.logistcshub.hub.common.domain.model.type.ResponseMessage.SUCCESS_GET_HUB;
import static com.logistcshub.hub.common.domain.model.type.ResponseMessage.SUCCESS_UPDATE_HUB;

import com.logistcshub.hub.common.domain.model.dtos.SuccessResponse;
import com.logistcshub.hub.hub.application.dtos.AddHubResponseDto;
import com.logistcshub.hub.hub.application.dtos.DeleteHubResponseDto;
import com.logistcshub.hub.hub.application.dtos.HubResponseDto;
import com.logistcshub.hub.hub.application.dtos.UpdateHubResponseDto;
import com.logistcshub.hub.hub.application.service.HubService;
import com.logistcshub.hub.hub.presentation.request.AddHubRequestDto;
import com.logistcshub.hub.hub.presentation.request.UpdateHubRequestDto;
import com.logistcshub.hub.hub.presentation.request.type.HubSearchType;
import com.logistcshub.hub.hub.presentation.request.type.SortType;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hubs")
@RequiredArgsConstructor
public class HubController {

    private final HubService hubService;

    @PostMapping
    public ResponseEntity<SuccessResponse<AddHubResponseDto>> addHub(@RequestBody AddHubRequestDto request,
                                                                        @RequestHeader(value = "X-USER-ID") Long userId,
                                                                        @RequestHeader(value = "X-USER-ROLE") String role) {
        userId = 1L;
        role = "MASTER";

        return ResponseEntity.ok().body(
                SuccessResponse.of(SUCCESS_CREATE_HUB, hubService.addHub(userId, role, request))
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<UpdateHubResponseDto>> updateHub(@RequestBody UpdateHubRequestDto request,
                                                                           @PathVariable UUID id,
                                                                           @RequestHeader(value = "X-USER-ID") Long userId,
                                                                           @RequestHeader(value = "X-USER-ROLE") String role) {
        userId = 1L;
        role = "MASTER";

        return ResponseEntity.ok().body(
                SuccessResponse.of(SUCCESS_UPDATE_HUB, hubService.updateHub(id, userId, role, request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<DeleteHubResponseDto>> deleteHub(@PathVariable UUID id,
                                                                           @RequestHeader(value = "X-USER-ID") Long userId,
                                                                           @RequestHeader(value = "X-USER-ROLE") String role) {
        userId = 1L;
        role = "MASTER";

        return ResponseEntity.ok().body(
                SuccessResponse.of(SUCCESS_DELETE_HUB, hubService.deleteHub(id, userId, role))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<HubResponseDto>> getHub(@PathVariable UUID id,
                                                                  @RequestHeader(value = "X-USER-ID") Long userId,
                                                                  @RequestHeader(value = "X-USER-ROLE") String role) {
        userId = 1L;
        role = "MASTER";

        return ResponseEntity.ok().body(
                SuccessResponse.of(SUCCESS_GET_HUB, hubService.getHub(id, userId, role))
        );
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<PagedModel<HubResponseDto>>> searchHubs(
                                                                             @RequestHeader(value = "X-USER-ID") Long userId,
                                                                             @RequestHeader(value = "X-USER-ROLE") String role,
                                                                             @RequestParam(name = "keyword", required = false) String keyword,
                                                                             @RequestParam(name = "type", defaultValue = "ALL") HubSearchType type,
                                                                             @PageableDefault Pageable pageable,
                                                                             @RequestParam(name = "sortBy", defaultValue = "CREATEDAT") SortType sortBy,
                                                                             @RequestParam(name = "isAsc", defaultValue = "true") boolean isAsc) {
        userId = 1L;
        role = "MASTER";

        return ResponseEntity.ok().body(
                SuccessResponse.of(SUCCESS_GET_HUB, hubService.searchHubs(userId, role, keyword, type, pageable, sortBy, isAsc))
        );
    }

}