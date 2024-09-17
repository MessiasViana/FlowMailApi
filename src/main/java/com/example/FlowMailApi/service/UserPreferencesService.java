package com.example.FlowMailApi.service;

import com.example.FlowMailApi.entity.UserPreferences;
import com.example.FlowMailApi.repository.UserPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserPreferencesService {

    @Autowired
    private UserPreferencesRepository repo;

    public List<UserPreferences> getAllPreferences() {
        return repo.findAll();
    }

    public UserPreferences savePreferences(UserPreferences preferences) {
        return repo.save(preferences);
    }

    public UserPreferences getPreferencesById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deletePreferences(Long id) {
        repo.deleteById(id);
    }
}
