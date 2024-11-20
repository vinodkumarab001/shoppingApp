package com.shoppingApp.inventory_service.controller;

import com.shoppingApp.inventory_service.dto.InventoryDto;
import com.shoppingApp.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    @Autowired
    private final InventoryService inventoryService;

    @GetMapping("/{productId}")
    public ResponseEntity<InventoryDto> getInventoryByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryService.getInventoryByProductId(productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<InventoryDto> updateInventory(
            @PathVariable Long productId,
            @RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.updateInventory(productId, inventoryDto));
    }
}
