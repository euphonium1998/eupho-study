package com.example.springsecurity.utils.web;

/**
 * @author 西云研究所
 * @date 2021/8/20
 */
public interface IStatus {

    /**
     * 状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 返回信息
     *
     * @return 返回信息
     */
    String getMessage();

}
