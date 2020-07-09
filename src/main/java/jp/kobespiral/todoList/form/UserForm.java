package jp.kobespiral.todoList.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.kobespiral.todoList.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    // ユーザID max16文字で英数字
    @Size(max = 16)
    @Pattern(regexp = "[0-9a-zA-Z_\\-]+")
    @NotBlank
    private String uid;

    // ユーザ名 空白以外
    @NotBlank
    private String name;

    public User toEntity() {
        return new User(null, uid, name, new Date());

    }

}