package com.bp.api.controller

import com.bp.api.model.BloodPressureRequest
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity

@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:5173"])
@RestController
@RequestMapping("/api")
class BloodPressureController {

    @PostMapping("/getbpcategory")
    ResponseEntity<Map> getCategory(@RequestBody BloodPressureRequest request) {
        def category = categorizeBP(request.systolic, request.diastolic)
        return ResponseEntity.ok([category: category])
    }

    private String categorizeBP(int systolic, int diastolic) {
        if (systolic < 70 || systolic > 190 || diastolic < 40 || diastolic > 100) {
            return "Invalid values"
        }
        if (systolic < 90 && diastolic < 60) return "Low"
        if (systolic < 120 && diastolic < 80) return "Ideal"
        if (systolic < 140 && diastolic < 90) return "PreHigh"
        return "High"
    }
}
