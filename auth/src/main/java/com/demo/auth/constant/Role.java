package com.demo.auth.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static com.demo.auth.constant.Permission.ADMIN_READ;
import static com.demo.auth.constant.Permission.ADMIN_UPDATE;
import static com.demo.auth.constant.Permission.ADMIN_CREATE;
import static com.demo.auth.constant.Permission.ADMIN_DELETE;

@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ADMIN(
        Set.of(
            ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_CREATE,
            ADMIN_DELETE
        )
    )
    ;

    @Getter
    private final Set<Permission> permissions;


}
