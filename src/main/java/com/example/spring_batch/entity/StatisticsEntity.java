package com.example.spring_batch.entity;

import com.example.spring_batch.entity.constant.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Table(name = "statistics")
@Entity
public class StatisticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statisticsId;
    private LocalDateTime statisticsAt;

    private int allCount;
    private int attendedCount;
    private int cancelledCount;

    @Builder
    public StatisticsEntity() {
    }

    public static StatisticsEntity create(final BookingEntity bookingEntity) {
        StatisticsEntity statisticsEntity = StatisticsEntity.builder().build();
        statisticsEntity.statisticsAt = bookingEntity.getStatisticsAt();
        statisticsEntity.allCount = 1;
        if (bookingEntity.isAttended()) {
            statisticsEntity.attendedCount = 1;
        }

        if (BookingStatus.CANCELLED.equals(bookingEntity.getStatus())) {
            statisticsEntity.cancelledCount = 1;
        }
        return statisticsEntity;
    }

    public void add(final BookingEntity bookingEntity) {
        this.allCount++;

        if (bookingEntity.isAttended()) {
            this.attendedCount++;
        }

        if (BookingStatus.CANCELLED.equals(bookingEntity.getStatus())) {
            this.cancelledCount++;
        }
    }
}
