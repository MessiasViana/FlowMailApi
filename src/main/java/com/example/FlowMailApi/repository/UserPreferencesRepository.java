package com.example.FlowMailApi.repository;

import com.example.FlowMailApi.entity.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferencesRepository extends JpaRepository<UserPreferences, Long> {

}
