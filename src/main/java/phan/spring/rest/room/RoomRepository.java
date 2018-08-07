package phan.spring.rest.room;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import phan.spring.rest.device.Device;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Room entity);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Room save(@Param("room") Room room);

    @RestResource(rel = "room-name", path = "containsName")
    Page<Device> findByNameContaining(@Param("name") String name, Pageable page);

    @RestResource(rel = "area-less-than", path = "hasAreaLessThan")
    Page<Device> findByAreaLessThan(@Param("area") Integer area, Pageable page);
}
