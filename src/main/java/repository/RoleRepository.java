package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
