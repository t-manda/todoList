package jp.kobespiral.todoList.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import jp.kobespiral.todoList.dto.UserDto;
import jp.kobespiral.todoList.form.UserForm;
import jp.kobespiral.todoList.service.UserService;

@ControllerAdvice
public class UserControllerAdvice {
    /**
     * NullPointerExceptionが発生した場合のエラー処理を行う
     * 
     * @param exception 発生した例外
     * @return NullPointerExceptionが発生した場合のエラー画面
     */
    @ExceptionHandler(NullPointerException.class)
    public String nullError(NullPointerException exception, Model model) {
        model.addAttribute("errMsg", exception.getMessage());
        return "error_null";
    }

    /**
     * FileNotFoundExceptionが発生した場合のエラー処理を行う HttpStatus.NOT_FOUND(404)をステータスとして返す
     * 
     * @param exception 発生した例外
     * @return FileNotFoundExceptionが発生した場合のエラー画面
     */
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noFileError(FileNotFoundException exception, Model model) {
        model.addAttribute("errMsg", exception.getMessage());
        return "error_no_file";
    }

    /**
     * 上記以外の例外が発生した場合のエラー処理を行う
     * 
     * @param exception 発生した例外
     * @return デフォルトのエラー画面
     */
    @ExceptionHandler(Exception.class)
    public String occurOtherException(Exception exception) {
        return "error";
    }

    /**
     * FormのValidationに対する例外処理 デフォルトではBindExceptionが発生する
     * 
     * @return 入力フォームのエラー画面
     */
    @ExceptionHandler(BindException.class)
    public String inputError(BindException exception, Model model) {
        model.addAttribute("errMsg", exception.getMessage());
        return "error_input";
    }
}