package com.chappy.portfolio2.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chappy.portfolio2.book.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    
}
