package jp.kobespiral.todoList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobespiral.todoList.dto.UserDto;
import jp.kobespiral.todoList.entity.User;
import jp.kobespiral.todoList.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository users;

    public UserDto getUser(String uid) {

        for (User u : users.findUserByUidLike("%" + uid + "%")) {
            return UserDto.build(u);// 1つ目を返す
        }
        return null;
    }

    public List<UserDto> getAllUsers() {
        ArrayList<UserDto> list = new ArrayList<UserDto>();
        for (User u : users.findAll()) {
            list.add(UserDto.build(u));

        }
        return list;
    }

    public UserDto addUser(User user) {
        Long id = user.getId();
        System.out.println(user);
        System.out.println("-----------------------------------");
        if (id != null && users.findById(id).isPresent()) {
            // 重複チェック
            return UserDto.build(users.save(user));
        } else {

            System.out.println("**********************************");
            return UserDto.build(users.save(user));
        }

    }

}