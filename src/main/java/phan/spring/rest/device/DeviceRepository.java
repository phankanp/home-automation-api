package phan.spring.rest.device;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import phan.spring.rest.control.Control;

public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {
    @RestResource(rel = "device-name", path = "deviceName")
    Page<Device> findByNameContaining(@Param("name") String name, Pageable page);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Device entity);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Device save(Device entity);

}
