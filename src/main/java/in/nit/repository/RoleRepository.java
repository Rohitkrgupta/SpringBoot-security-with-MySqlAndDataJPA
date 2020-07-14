package in.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
