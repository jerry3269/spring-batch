package com.example.spring_batch.entity;

import com.example.spring_batch.entity.constant.BulkPassStatus;
import com.example.spring_batch.entity.constant.PassStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Table(name = "bulk_pass")
@Entity
public class BulkPassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bulkPassId;
    private Integer packageId;
    private String userGroupId;

    @Enumerated(EnumType.STRING)
    private BulkPassStatus status;
    private Integer count;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
