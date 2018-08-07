package phan.spring.rest.control;

import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import phan.spring.rest.user.User;
import phan.spring.rest.user.UserRepository;

@Component
@RepositoryEventHandler(Control.class)
public class ControlEventHandler {
    private final UserRepository users;

    public ControlEventHandler(UserRepository users) {
        this.users = users;
    }

    //Before saving control, logged in user will be set a last modified by
    @HandleBeforeSave
    public void setUserAsLastModifedWhenSaving(Control control) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        control.setLastModifiedBy(user);
    }


}
