package in.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUserName(String username);

}
