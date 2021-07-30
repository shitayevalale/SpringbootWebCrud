package az.java.SpringWeb.repository;

import az.java.SpringWeb.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public Long countById(Integer id);
}
