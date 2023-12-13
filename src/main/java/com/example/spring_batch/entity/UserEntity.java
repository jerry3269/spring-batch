package com.example.spring_batch.entity;

import com.example.spring_batch.entity.constant.UserStatus;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import java.util.Map;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Table(name = "member")
@Entity
public class UserEntity extends BaseEntity {
    @Id
    private String userId;

    private String username;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String phone;

    @Type(JsonType.class)
    @Column(columnDefinition = "longtext")
    private Map<String, Object> meta;

    public String getUuid() {
        String uuid = null;
        if (meta.containsKey("uuid")) {
            uuid = String.valueOf(meta.get("uuid"));
        }
        return uuid;
    }
}
