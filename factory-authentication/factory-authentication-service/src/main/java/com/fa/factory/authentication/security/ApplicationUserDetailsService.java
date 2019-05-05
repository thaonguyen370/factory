package com.fa.factory.authentication.security;

import com.fa.factory.admin.interfaces.AdminClient;
import com.fa.factory.admin.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    private final AdminClient adminClient;

    public ApplicationUserDetailsService(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto account = adminClient.findUserByUsername(username).getData();

        if (account.getUserName().equals(username)) {
            List<GrantedAuthority> authorities = account.getListRoleId()
                    .stream()
                    .map(integer -> new SimpleGrantedAuthority(
                            adminClient.findRoleById(integer)
                                    .getData().getRoleName()))
                    .collect(Collectors.toList());
            return new User(account.getUserName(), account.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("User " + username + " is not found!");
    }
}
