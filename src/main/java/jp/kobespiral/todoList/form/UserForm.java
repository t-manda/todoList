package jp.kobespiral.todoList.form;

import java.util.Date;

import jp.kobespiral.todoList.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    // ユーザID
    private String uid;

    // ユーザ名
    private String name;

    public User toEntity() {
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");

        return new User(null, uid, name, new Date());

    }

}