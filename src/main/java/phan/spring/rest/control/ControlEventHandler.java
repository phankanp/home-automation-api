package phan.spring.rest.control;

import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import phan.spring.rest.user.User;
import phan.spring.rest.user.UserRepository;

@RepositoryEventHandler(Control.class)
public class ControlEventHandler {
    private final UserRepository users;

    public ControlEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeSave
    public void setUserAsLastModifedWhenSaving(Control control) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        control.setLastModifiedBy(user);
    }


}
