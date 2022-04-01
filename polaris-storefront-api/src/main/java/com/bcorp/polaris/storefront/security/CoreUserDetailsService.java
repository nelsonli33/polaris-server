package com.bcorp.polaris.storefront.security;

import com.bcorp.polaris.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoreUserDetailsService implements UserDetailsService
{
    private UserDao userDao;

    @Autowired
    public CoreUserDetailsService(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        final Optional<UserRecord> userRecord = userDao.findUserByUid(username);
        if (!userRecord.isPresent())
        {
            throw new UsernameNotFoundException("User: " + username + " not found.");
        }
        final UserRecord user = userRecord.get();


        List<GrantedAuthority> authorities = new ArrayList();
        if (user.getIsAuthor().intValue() == 1)
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_AUTHOR"));
        }

        return User.builder()
                .username(user.getUid())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
