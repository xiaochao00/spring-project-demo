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

    @Test
    public void testProxy2() {
        // 带参构造器的代理；注意两点，1.代理类必须有无参构造器；2.优先利用set方式注入属性而不是构造器方式；
        Book2 book2 = CglibProxyUtils.createProxyInstance(new Book2());
        logger.info("here class:{}.", book2.getClass());
        book2.getPrice();
        // 如果一定要使用带参构造器
        Book2 book21 = CglibProxyUtils.createProxyInstance(new Book2(), new Class[]{int.class}, new Object[]{10});
        logger.info("Here class:{}.", book21.getPrice());
        book21.getPrice();
    }

    static class Book2 {
        private int price;

        Book2() {
            // cglib 代理的类必须有无参构造器
        }

        Book2(int price) {
            this.price = price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            logger.info("Get price:{}.", price);
            return price;
        }
    }
}