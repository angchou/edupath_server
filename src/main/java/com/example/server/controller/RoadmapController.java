package com.example.server.controller;

import com.example.server.dto.request.EditRoadmapRequest;
import com.example.server.dto.request.UpdateRoadmapDescRequest;
import com.example.server.dto.response.PublicRoadmapResponse;
import com.example.server.dto.response.RoadmapResponse;
import com.example.server.service.RoadmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roadmap")
@CrossOrigin(origins = "http://localhost:6969")
public class RoadmapController {

    @Autowired
    private RoadmapService roadmapService;

    @GetMapping("/get/my_share")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public RoadmapResponse getMyShareRoadmap() {
        return roadmapService.getMyShareRoadmap();
    }

    @GetMapping("/get/roadmap")
    public RoadmapResponse getMyRoadmap() {
        return roadmapService.getMyRoadmap();
    }

    @GetMapping("/get/public")
    @PreAuthorize("isAuthenticated()")
    public List<PublicRoadmapResponse> getPublicRoadmap() {
        return roadmapService.getPublicRoadmap();
    }

    // we only have editing roadmap, system will automatically create a new roadmap if user didn't have one
    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('MENTOR', 'LEARNER')")
    public ResponseEntity<?> saveRoadmap(@RequestBody EditRoadmapRequest request) {
        return roadmapService.saveRoadmap(request);
    }

    @PostMapping("/edit_desc")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> editRoadmapDesc(@RequestBody UpdateRoadmapDescRequest request) {
        return roadmapService.editRoadmapDesc(request);
    }

    @PostMapping("/copy/{loTrinhID}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> copyRoadmap(@PathVariable String loTrinhID) {
        return roadmapService.copyRoadmap(loTrinhID);
    }

    @PatchMapping("/public/{loTrinhID}")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> changeRoadmapStatus(@PathVariable String loTrinhID) {
        return roadmapService.changeRoadmapStatus(loTrinhID);
    }

}
