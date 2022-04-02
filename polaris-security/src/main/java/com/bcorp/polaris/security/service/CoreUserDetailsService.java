package com.bcorp.polaris.security.service;

import com.bcorp.polaris.core.dao.UserDao;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

        return CoreUserDetails
                .builder()
                .username(user.getUid())
                .password(user.getPassword())
                .userRecord(user)
                .authorities(authorities)
                .build();
    }
}
