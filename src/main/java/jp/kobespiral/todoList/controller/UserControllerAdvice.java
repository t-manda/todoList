package jp.kobespiral.todoList.controller;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserControllerAdvice {
    // /**
    // * NullPointerExceptionが発生した場合のエラー処理を行う
    // *
    // * @param exception 発生した例外
    // * @return NullPointerExceptionが発生した場合のエラー画面
    // */
    // @ExceptionHandler(NullPointerException.class)
    // public String nullError(NullPointerException exception, Model model) {
    // model.addAttribute("errMsg", exception.getMessage());
    // return "error_null";
    // }

    // /**
    // * 上記以外の例外が発生した場合のエラー処理を行う
    // *
    // * @param exception 発生した例外
    // * @return デフォルトのエラー画面
    // */
    // @ExceptionHandler(Exception.class)
    // public String occurOtherException(Exception exception) {
    // return "error";
    // }

    // ここから下は使ってるやつ---------------------------------------------

    /**
     * FormのValidationに対する例外処理 デフォルトではBindExceptionが発生する
     * 
     * @return 入力フォームのエラー画面
     */
    @ExceptionHandler(BindException.class)
    public String inputError(BindException exception, Model model) {
        // model.addAttribute("errMsg", exception.getMessage());
        model.addAttribute("errMsg", "入力エラーが発生しました");
        return "error";
    }

    /**
     * AccessDeniedException DBでのuid重複が発生した時に起こす
     * 
     * @param exception 発生した例外
     * @return NullPointerExceptionが発生した場合のエラー画面
     */
    @ExceptionHandler(AccessDeniedException.class)
    public String accessError(AccessDeniedException exception, Model model) {
        model.addAttribute("errMsg", "uidが重複しています");
        return "error";
    }

    /**
     * FileNotFoundException データが存在しない時に返す
     * 
     * @param exception 発生した例外
     * @return FileNotFoundExceptionが発生した場合のエラー画面
     */
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noDataError(FileNotFoundException exception, Model model) {
        model.addAttribute("errMsg", "データが見つかりません");
        return "error";
    }

}