package com.ead.authuser.clients;

import com.ead.authuser.dtos.CourseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class UserClient {

    private final RestTemplate restTemplate;

    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Page<CourseDTO> getAllCoursesByUser(UUID userId, Pageable pageable) {
        return null;
    }

}
