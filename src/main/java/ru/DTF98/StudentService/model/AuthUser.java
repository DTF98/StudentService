package ru.DTF98.StudentService.model;

import io.micrometer.common.lang.NonNull;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class AuthUser extends User implements UserDetails {

    private final User user;

    public AuthUser(User user) {
        this.user = user;
    }

    @NonNull
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @NonNull
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
