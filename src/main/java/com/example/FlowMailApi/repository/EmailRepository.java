package com.example.FlowMailApi.repository;

import com.example.FlowMailApi.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long>{


}
