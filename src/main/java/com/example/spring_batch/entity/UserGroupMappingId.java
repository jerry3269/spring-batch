package com.example.spring_batch.entity;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class UserGroupMappingId implements Serializable {
    private String userGroupId;
    private String userId;
}
