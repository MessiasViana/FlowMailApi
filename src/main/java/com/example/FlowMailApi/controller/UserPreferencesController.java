package com.example.FlowMailApi.controller;

import com.example.FlowMailApi.entity.UserPreferences;
import com.example.FlowMailApi.service.UserPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserPreferencesController {

    @Autowired
    private UserPreferencesService preferencesService;

    @GetMapping
    public List<UserPreferences> getAllPreferences() {
        return preferencesService.getAllPreferences();
    }

    @PostMapping
    public UserPreferences savePreferences(@RequestBody UserPreferences preferences) {
        return preferencesService.savePreferences(preferences);
    }

    @GetMapping("/{id}")
    public UserPreferences getPreferencesById(@PathVariable Long id) {
        return preferencesService.getPreferencesById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePreferences(@PathVariable Long id) {
        preferencesService.deletePreferences(id);
    }
}
