package io.imking.security.entity;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Spring Security User
 *
 * @author yang.zhang3
 * @create 2017/11/16
 */
public class SecurityUser extends User implements UserDetails {
    public SecurityUser(User user){
        if(user != null){
            BeanUtils.copyProperties(user, this);
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //此处的角色名称前面要加上“ROLE_”前缀，权限验证时会默认加上前缀“ROLE_”
        if("admin".equalsIgnoreCase(this.getUsername())){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else{
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return "e10adc3949ba59abbe56e057f20f883e";
    }

    @Override
    public String getUsername() {
        return super.getUserName();
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
