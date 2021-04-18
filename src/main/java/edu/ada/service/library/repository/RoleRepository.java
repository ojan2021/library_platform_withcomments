package edu.ada.service.library.repository;

import java.util.Optional;

import edu.ada.service.library.model.dto.ERole;
import edu.ada.service.library.model.dto.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
