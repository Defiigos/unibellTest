package com.example.unibelltest.repos;

import com.example.unibelltest.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
