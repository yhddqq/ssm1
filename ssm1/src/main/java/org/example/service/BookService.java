package org.example.service;

import org.example.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//如果mybatis的扫描包也有这个，所以此接口也被spring管理，导致spring调用方法时在此接口上调用sql方法而不是实现类上，导致运行出错
@Transactional  //事务
public interface BookService {
    boolean save(Book book);

    boolean update(Book book);

    boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();
}
