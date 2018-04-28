package spitter.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spitter.Spitter;
import spitter.data.SpitterRepository;

import java.util.ArrayList;
import java.util.List;

public class SpitterUserService implements UserDetailsService {
    private SpitterRepository spitterRepository;

    public SpitterUserService(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter = spitterRepository.findByUserName(username);
        if (spitter != null) {
            List<GrantedAuthority> authorities =
                    new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            return new User(
                    spitter.getUserName(),
                    spitter.getPassword(),
                    authorities);
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
