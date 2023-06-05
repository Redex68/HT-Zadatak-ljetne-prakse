package hr.ht.marin.zadatak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hr.ht.marin.zadatak.entitiy.AppUser;
import hr.ht.marin.zadatak.service.AppUserService;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserService.getUser(username);
        return new User(
            user.getUsername(), 
            user.getPassword(), 
            AuthorityUtils.commaSeparatedStringToAuthorityList(user.authoritiesToString())
        );
    }
    
}
