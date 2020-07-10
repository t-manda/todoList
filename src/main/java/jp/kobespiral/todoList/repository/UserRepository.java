package jp.kobespiral.todoList.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.todoList.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public Iterable<User> findUserByUid(String uid);

}