package com.ead.authuser.controllers;

import com.ead.authuser.clients.UserClient;
import com.ead.authuser.dtos.CourseDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserCourseController {

    private final UserClient userClient;

    public UserCourseController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/users/{userId}/courses")
    public ResponseEntity<Page<CourseDTO>> getAllCoursesByUser(
            @PathVariable("userId") UUID userId,
            @PageableDefault(page = 0, size = 10, sort = "courseId", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok(userClient.getAllCoursesByUser(userId, pageable));
    }

}
