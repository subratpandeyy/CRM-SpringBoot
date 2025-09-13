package com.crm.service;

import com.crm.dto.ActivityDto;
import com.crm.entity.Activity;
import com.crm.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActivityService {
    
    @Autowired
    private ActivityRepository activityRepository;
    
    public ActivityDto createActivity(ActivityDto activityDto) {
        // For now, return a mock activity
        ActivityDto mockActivity = new ActivityDto();
        mockActivity.setActivityId(1L);
        mockActivity.setActivityType(activityDto.getActivityType());
        mockActivity.setSubject(activityDto.getSubject());
        mockActivity.setDescription(activityDto.getDescription());
        mockActivity.setOrgId(activityDto.getOrgId());
        return mockActivity;
    }
    
    public List<ActivityDto> getActivitiesByOrganization(Long orgId) {
        // For now, return empty list
        return new ArrayList<>();
    }
    
    public ActivityDto getActivityById(Long activityId) {
        // For now, return a mock activity
        ActivityDto mockActivity = new ActivityDto();
        mockActivity.setActivityId(activityId);
        mockActivity.setActivityType("Call");
        mockActivity.setSubject("Mock Activity");
        mockActivity.setDescription("This is a mock activity");
        return mockActivity;
    }
    
    public ActivityDto updateActivity(Long activityId, ActivityDto activityDto) {
        // For now, return the updated DTO
        activityDto.setActivityId(activityId);
        return activityDto;
    }
    
    public void deleteActivity(Long activityId) {
        // For now, do nothing
    }
}
