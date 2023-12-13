package com.example.spring_batch.entity;

import com.example.spring_batch.entity.BaseEntity;
import com.example.spring_batch.entity.constant.PassStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pass")
@Entity
public class PassEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passId;
    private Integer packageId;
    private String userId;

    @Enumerated(EnumType.STRING)
    private PassStatus status;
    private Integer remainingCount;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime expiredAt;

    public void update(PassStatus status, LocalDateTime expiredAt) {
        this.status = status;
        this.expiredAt = expiredAt;
    }

    @Builder
    public PassEntity(Integer passId, Integer packageId, String userId, PassStatus status, Integer remainingCount, LocalDateTime startedAt, LocalDateTime endedAt, LocalDateTime expiredAt) {
        this.passId = passId;
        this.packageId = packageId;
        this.userId = userId;
        this.status = status;
        this.remainingCount = remainingCount;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.expiredAt = expiredAt;
    }
}
