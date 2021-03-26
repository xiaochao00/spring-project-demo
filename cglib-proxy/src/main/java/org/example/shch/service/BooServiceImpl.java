package org.example.shch.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Book Service Implement
 *
 * @author shichao
 * @since 1.0.0
 * 2021/3/27 0:18
 */
public class BooServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(BooServiceImpl.class);

    @Override
    public void addBook(String name, String author) {
        logger.info("Add book name:{} author:{}.", name, author);
    }
}
