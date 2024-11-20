package com.shoppingApp.inventory_service.service;


import com.shoppingApp.inventory_service.dto.InventoryDto;
import com.shoppingApp.inventory_service.entity.Inventory;
import com.shoppingApp.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    @Autowired
    private final InventoryRepository inventoryRepository;

    public InventoryDto getInventoryByProductId(Long productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Inventory not found for product ID: " + productId));
        return toDto(inventory);
    }

    public InventoryDto updateInventory(Long productId, InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Inventory not found for product ID: " + productId));

        inventory.setInventoryTotal(inventoryDto.getInventoryTotal());
        inventory.setInventoryAvailable(inventoryDto.getInventoryAvailable());
        inventory.setInventoryReserved(inventoryDto.getInventoryReserved());

        return toDto(inventoryRepository.save(inventory));
    }

    private InventoryDto toDto(Inventory inventory) {
        return InventoryDto.builder()
                .productId(inventory.getProductId())
                .inventoryTotal(inventory.getInventoryTotal())
                .inventoryAvailable(inventory.getInventoryAvailable())
                .inventoryReserved(inventory.getInventoryReserved())
                .build();
    }
}
