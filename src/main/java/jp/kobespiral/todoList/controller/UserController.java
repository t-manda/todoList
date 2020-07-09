package jp.kobespiral.todoList.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.kobespiral.todoList.dto.UserDto;
import jp.kobespiral.todoList.form.UserForm;
import jp.kobespiral.todoList.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService us;

    /**
     * NullPointerExceptionを発生させる Runtime Exception
     */
    @GetMapping("/occurNullPointerException")
    public String occurNullPointerException() {
        throw new NullPointerException("NullPointerExceptionが発生しました");
    }

    /**
     * FileNotFoundExceptionを発生させる 検査例外
     * 
     * @throws FileNotFoundException
     */
    @GetMapping("/occurFileNotFoundException")
    public String occurFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException("FileNotFoundExceptionが発生しました");
    }

    /**
     * IOExceptionを発生させる 検査例外 HelloExceptionControllerAdviceで特にキャッチしない例外
     * 
     * @throws Exception
     */
    @GetMapping("/occurOtherException")
    public String occurOtherException() throws IOException {
        throw new IOException("IOExceptionが発生しました");
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute("form") @Validated UserForm form, Model model) {
        UserDto u = us.addUser(form.toEntity());
        model.addAttribute("user", u);
        return "success";
    }

    @GetMapping("/user/{uid}")
    public String showUser(@PathVariable String uid, Model model) {
        UserDto u = us.getUser(uid);
        model.addAttribute("user", u);
        return "userinfo";
    }

    @GetMapping("/users")
    public String showAllUser(Model model) {
        List<UserDto> userList = us.getAllUsers();
        model.addAttribute("ulist", userList);
        return "alluserlist";
    }

}