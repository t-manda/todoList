package jp.kobespiral.todoList.service;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Collection;
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

    // uidからユーザ検索
    // 複数（ないと思うけど）あれば1つ目を取る
    public UserDto getUser(String uid) {

        for (User u : users.findUserByUid("%" + uid + "%")) {
            return UserDto.build(u);// 1つ目を返す
        }
        return null;
    }

    // 全要素の取得
    public List<UserDto> getAllUsers() throws FileNotFoundException {
        ArrayList<UserDto> list = new ArrayList<UserDto>();
        for (User u : users.findAll()) {
            list.add(UserDto.build(u));

        }

        // 中身が0ならエラー
        if (list.size() == 0) {
            throw new FileNotFoundException(null);
        }
        return list;
    }

    // ユーザ追加
    public UserDto addUser(User user) throws AccessDeniedException {
        String uid = user.getUid();
        // id重複があればエラー
        if (size(users.findUserByUid(uid)) != 0) {
            throw new AccessDeniedException(null);
        } else {
            return UserDto.build(users.save(user));
        }

    }

    // Iterable型の長さを取得
    public static int size(Iterable data) {

        if (data instanceof Collection) {
            return ((Collection<?>) data).size();
        }
        int counter = 0;
        for (Object i : data) {
            counter++;
        }
        return counter;
    }

}