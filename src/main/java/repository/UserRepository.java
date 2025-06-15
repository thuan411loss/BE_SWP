package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByRoleRoleName(String roleName);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
