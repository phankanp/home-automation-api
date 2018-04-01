package phan.spring.rest.control;

import org.hibernate.validator.constraints.NotEmpty;
import phan.spring.rest.core.BaseEntity;
import phan.spring.rest.device.Device;
import phan.spring.rest.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Control extends BaseEntity {

    @NotNull
    @NotEmpty
    private String name;

    @ManyToOne
    @NotNull
    private Device device;

    @NotNull
    private int value;

    @ManyToOne
    private User lastModifiedBy;

    protected Control() {
        super();
    }

    public Control(String name) {
        this();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
