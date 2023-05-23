package com.api.clientes.repository;

import com.api.clientes.model.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
    Optional<PasswordResetToken> findByToken(String token);

    @Query("SELECT p FROM PasswordResetToken p WHERE p.expiryDate < :now")
    List<PasswordResetToken> findByDataExpiracaoBefore(@Param("now") LocalDateTime now);

}
