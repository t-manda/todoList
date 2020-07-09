package jp.kobespiral.todoList.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchUserForm {

    // ユーザID max16文字で英数字
    @Size(max = 16)
    @Pattern(regexp = "[0-9a-zA-Z_\\-]+")
    @NotBlank
    private String uid;

}