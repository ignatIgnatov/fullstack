package com.example.restapi.repository;

import com.example.restapi.model.ContactMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessageEntity, Long> {
}
