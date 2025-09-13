package com.crm.service;

import com.crm.dto.DealDto;
import com.crm.entity.Deal;
import com.crm.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DealService {
    
    @Autowired
    private DealRepository dealRepository;
    
    public DealDto createDeal(DealDto dealDto) {
        // For now, return a mock deal
        DealDto mockDeal = new DealDto();
        mockDeal.setDealId(1L);
        mockDeal.setDealName(dealDto.getDealName());
        mockDeal.setDealValue(dealDto.getDealValue());
        mockDeal.setDealStage(dealDto.getDealStage());
        mockDeal.setOrgId(dealDto.getOrgId());
        return mockDeal;
    }
    
    public List<DealDto> getDealsByOrganization(Long orgId) {
        // For now, return empty list
        return new ArrayList<>();
    }
    
    public DealDto getDealById(Long dealId) {
        // For now, return a mock deal
        DealDto mockDeal = new DealDto();
        mockDeal.setDealId(dealId);
        mockDeal.setDealName("Mock Deal");
        mockDeal.setDealValue(new BigDecimal("10000.00"));
        mockDeal.setDealStage("Proposal");
        return mockDeal;
    }
    
    public DealDto updateDeal(Long dealId, DealDto dealDto) {
        // For now, return the updated DTO
        dealDto.setDealId(dealId);
        return dealDto;
    }
    
    public void deleteDeal(Long dealId) {
        // For now, do nothing
    }
}
