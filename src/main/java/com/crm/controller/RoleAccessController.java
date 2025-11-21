package com.crm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Simple role-specific endpoints to verify role-based access control.
 *
 * - /api/access/manager    -> Manager-only
 * - /api/access/sales-rep  -> Sales Rep-only
 */
@RestController
@RequestMapping("/api/access")
@CrossOrigin(origins = "*")
public class RoleAccessController {

    @GetMapping("/manager")
    @PreAuthorize("hasRole('Manager')")
    public ResponseEntity<?> managerOnly(Authentication authentication) {
        return ResponseEntity.ok(buildResponse(authentication, "Manager"));
    }

    @GetMapping("/sales-rep")
    @PreAuthorize("hasRole('Sales Rep')")
    public ResponseEntity<?> salesRepOnly(Authentication authentication) {
        return ResponseEntity.ok(buildResponse(authentication, "Sales Rep"));
    }

    private Map<String, Object> buildResponse(Authentication authentication, String requiredRole) {
        Map<String, Object> body = new HashMap<>();
        body.put("username", authentication != null ? authentication.getName() : null);

        List<String> roles = authentication != null
                ? authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList())
                : List.of();

        body.put("authorities", roles);
        body.put("requiredRole", requiredRole);
        body.put("message", "Access granted to " + requiredRole + " endpoint");
        return body;
    }
}
