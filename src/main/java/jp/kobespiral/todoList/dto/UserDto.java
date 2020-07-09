package jp.kobespiral.todoList.dto;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jp.kobespiral.todoList.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    // DB用ID
    @Id
    private Long id;

    // ユーザID
    private String uid;

    // ユーザ名
    private String name;

    // 作成した時間
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedAt;

    public static UserDto build(User u) {
        return new UserDto(u.getId(), u.getUid(), u.getName(), u.getCheckedAt());
    }

}