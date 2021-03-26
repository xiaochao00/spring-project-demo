package org.example.shch.service;

/**
 * book service interface
 *
 * @author shichao
 * @since 1.0.0
 * 2021/3/27 0:17
 */
public interface BookService {
    /**
     * 添加书
     *
     * @param name   书名
     * @param author 作者
     */
    void addBook(String name, String author);
}
