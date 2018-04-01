package phan.spring.rest.room;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Room entity);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Room save(@Param("room") Room room);
}
