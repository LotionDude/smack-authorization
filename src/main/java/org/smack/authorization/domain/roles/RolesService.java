package org.smack.authorization.domain.roles;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    // todo
    public List<String> getUserRoles(String user) {
        if (user.equals("lotan")) {
            return List.of("admin", "moderator", "user");
        } else if (user.equals("erase")) {
            return List.of("muted", "user");
        } else {
            return List.of("user");
        }
    }
}
