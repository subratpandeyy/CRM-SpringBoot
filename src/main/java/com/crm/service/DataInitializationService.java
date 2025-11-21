package com.crm.service;

import com.crm.entity.Member;
import com.crm.entity.Organization;
import com.crm.entity.Role;
import com.crm.repository.MemberRepository;
import com.crm.repository.OrganizationRepository;
import com.crm.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DataInitializationService implements CommandLineRunner {
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private OrganizationRepository organizationRepository;
    
    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        initializeRoles();
        initializeTestData();
    }
    
    private void initializeRoles() {
        if (roleRepository.count() == 0) {
            // Create default roles
            Role adminRole = new Role("Admin");
            Role managerRole = new Role("Manager");
            Role salesRepRole = new Role("Sales Rep");
            Role userRole = new Role("User");
            
            roleRepository.save(adminRole);
            roleRepository.save(managerRole);
            roleRepository.save(salesRepRole);
            roleRepository.save(userRole);
            
            System.out.println("Default roles initialized successfully");
        }
    }
    
    private void initializeTestData() {
        // Create test organization if it doesn't exist
        if (organizationRepository.count() == 0) {
            Organization testOrg = new Organization();
            testOrg.setOrgName("Test Organization");
            testOrg.setOrgEmail("admin@testorg.com");
            organizationRepository.save(testOrg);
            
            System.out.println("Test organization created successfully");
        }
        
        // Create test users if none exist
        if (memberRepository.count() == 0) {
            // Get the first organization and roles
            Organization testOrg = organizationRepository.findAll().get(0);
            Role adminRole = roleRepository.findByRoleName("Admin").orElse(null);
            Role managerRole = roleRepository.findByRoleName("Manager").orElse(null);
            Role salesRepRole = roleRepository.findByRoleName("Sales Rep").orElse(null);
            
            if (testOrg != null && adminRole != null && managerRole != null && salesRepRole != null) {
                // Admin user
                Member adminUser = new Member();
                adminUser.setName("Test Admin");
                adminUser.setEmail("admin@test.com");
                adminUser.setPassword(passwordEncoder.encode("password123"));
                adminUser.setStatus(Member.MemberStatus.ACTIVE);
                adminUser.setOrganization(testOrg);
                adminUser.setRole(adminRole);
                memberRepository.save(adminUser);
                
                // Manager user
                Member managerUser = new Member();
                managerUser.setName("Test Manager");
                managerUser.setEmail("manager@test.com");
                managerUser.setPassword(passwordEncoder.encode("password123"));
                managerUser.setStatus(Member.MemberStatus.ACTIVE);
                managerUser.setOrganization(testOrg);
                managerUser.setRole(managerRole);
                memberRepository.save(managerUser);
                
                // Sales Rep user
                Member salesRepUser = new Member();
                salesRepUser.setName("Test Sales Rep");
                salesRepUser.setEmail("sales@test.com");
                salesRepUser.setPassword(passwordEncoder.encode("password123"));
                salesRepUser.setStatus(Member.MemberStatus.ACTIVE);
                salesRepUser.setOrganization(testOrg);
                salesRepUser.setRole(salesRepRole);
                memberRepository.save(salesRepUser);
                
                System.out.println("Test users created successfully:");
                System.out.println("Admin   -> Email: admin@test.com  Password: password123");
                System.out.println("Manager -> Email: manager@test.com Password: password123");
                System.out.println("Sales   -> Email: sales@test.com   Password: password123");
            }
        }
    }
}
