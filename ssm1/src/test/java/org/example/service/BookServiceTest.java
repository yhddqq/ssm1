package org.example.service;

import org.example.config.SpringConfig;
import org.example.dao.BookDao;
import org.example.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ApplicationContext testContext;

    @Test
    public void testGetById() {
        // 输出spring容器中的所有bean的名字
        System.out.println("Spring 测试框架创建的容器地址: " + System.identityHashCode(testContext));
        System.out.println("Spring 测试框架创建的容器地址: " + testContext);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("原本手动创建的 Spring 容器地址: " + System.identityHashCode(context));
        System.out.println("原本手动创建的 Spring 容器地址: " + context);
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        Book book = bookService.getById(1);
        System.out.println(book);
        Book book2 = bookService.getById(1);
        System.out.println(book2);

        System.out.println("-------------------");
        System.out.println(bookDao);
        BookDao bookDao2 = (BookDao) context.getBean("bookDao");
        BookDao bookDao3 = (BookDao) context.getBean("bookDao");
        System.out.println("-------------------");

        System.out.println(bookDao2);
        System.out.println(bookDao3);
        System.out.println("-------------------");

        System.out.println(bookService);
        BookService bookService2 = (BookService) context.getBean("bookServiceImpl");
        BookService bookService3 = (BookService) context.getBean("bookServiceImpl");
        System.out.println("-------------------");

        System.out.println(bookService2);
        System.out.println(bookService3);

        System.out.println("-------------------");
        AnnotationConfigApplicationContext manualContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 打印 Spring 测试框架创建的容器地址
        System.out.println("Spring 测试框架创建的容器地址: " + System.identityHashCode(testContext));
        System.out.println("Spring 测试框架创建的容器地址: " + testContext);
        // 打印手动创建的 Spring 容器地址
        System.out.println("手动创建的 Spring 容器地址: " + System.identityHashCode(manualContext));
        System.out.println("手动创建的 Spring 容器地址: " + manualContext);
        manualContext.close();

    }

    @Test
    public void testGetAll() {
        List<Book> bookAll = bookService.getAll();
        System.out.println(bookAll);
    }
}
