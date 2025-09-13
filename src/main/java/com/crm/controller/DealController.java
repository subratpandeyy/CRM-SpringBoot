package com.crm.controller;

import com.crm.dto.DealDto;
import com.crm.service.DealService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deals")
@CrossOrigin(origins = "*")
public class DealController {
    
    @Autowired
    private DealService dealService;
    
    @PostMapping
    public ResponseEntity<?> createDeal(@Valid @RequestBody DealDto dealDto, Authentication authentication) {
        try {
            Long orgId = getOrgIdFromAuthentication(authentication);
            dealDto.setOrgId(orgId);
            
            DealDto createdDeal = dealService.createDeal(dealDto);
            return ResponseEntity.ok(createdDeal);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<?> getDealsByOrganization(Authentication authentication) {
        try {
            Long orgId = getOrgIdFromAuthentication(authentication);
            List<DealDto> deals = dealService.getDealsByOrganization(orgId);
            return ResponseEntity.ok(deals);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    
    @GetMapping("/{dealId}")
    public ResponseEntity<?> getDealById(@PathVariable Long dealId) {
        try {
            DealDto deal = dealService.getDealById(dealId);
            return ResponseEntity.ok(deal);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    
    @PutMapping("/{dealId}")
    public ResponseEntity<?> updateDeal(@PathVariable Long dealId, @Valid @RequestBody DealDto dealDto) {
        try {
            DealDto updatedDeal = dealService.updateDeal(dealId, dealDto);
            return ResponseEntity.ok(updatedDeal);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/{dealId}")
    public ResponseEntity<?> deleteDeal(@PathVariable Long dealId) {
        try {
            dealService.deleteDeal(dealId);
            return ResponseEntity.ok("Deal deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    
    private Long getOrgIdFromAuthentication(Authentication authentication) {
        // Extract orgId from JWT token claims
        if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
            return 1L; // Default orgId for now
        }
        return 1L; // Default fallback
    }
}
