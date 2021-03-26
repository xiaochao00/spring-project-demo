package org.example.shch.util;

import org.example.shch.service.BooServiceImpl;
import org.example.shch.service.BookService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CglibProxyUtilsTest {
    private static final Logger logger = LoggerFactory.getLogger(CglibProxyUtilsTest.class);

    @Test
    public void testProxy() {
        BookService bookService = CglibProxyUtils.createProxyInstance(new BooServiceImpl());
        logger.info("here class:{}.", bookService.getClass());
        bookService.addBook("the moon and six pence", "mao mu");
    }
}