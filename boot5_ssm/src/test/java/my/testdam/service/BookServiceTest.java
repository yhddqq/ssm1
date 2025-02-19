package my.testdam.service;

import my.testdam.dao.BookDao;
import my.testdam.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetAll() {
        List<Book> bookAll = bookService.getAll();
        System.out.println(bookAll);
    }

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ApplicationContext testContext;

    @Test
    public void testGetById() {
        // 输出spring容器中的所有bean的名字
        System.out.println("Spring 测试框架创建的容器地址: " + System.identityHashCode(testContext));
        System.out.println("Spring 测试框架创建的容器地址: " + testContext);

        Book book = bookService.getById(2);
        System.out.println(book);
        Book book2 = bookService.getById(3);
        System.out.println(book2);
//        Book book3 = bookService.getById(1);
//        System.out.println(book3);

        System.out.println("-------------------");
        System.out.println(bookDao);

        System.out.println("-------------------");

        System.out.println(bookService);

        System.out.println("-------------------");

        // 打印 Spring 测试框架创建的容器地址
        System.out.println("Spring 测试框架创建的容器地址: " + System.identityHashCode(testContext));
        System.out.println("Spring 测试框架创建的容器地址: " + testContext);


    }
}
