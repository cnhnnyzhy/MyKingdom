package io.imking.admin.service;

import io.imking.admin.model.SecurityAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 自定义UserDetailsService
 *
 * @author ocean
 * @date 2017/11/11
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new SecurityAccount(userName, "e10adc3949ba59abbe56e057f20f883e");
    }
}
