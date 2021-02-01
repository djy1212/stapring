package com.stapring.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자"),
    PAID_MEMBER("ROLE_PAID_MEMBER", "유료 사용자");

    private final String key;
    private final String title;

}

