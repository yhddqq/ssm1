package my.testdam.service.impl;

import my.testdam.controller.Code;
import my.testdam.dao.BookDao;
import my.testdam.domain.Book;
import my.testdam.exception.BusinessException;
import my.testdam.exception.SystemException;
import my.testdam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

//    @Autowired
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book)> 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
//        try {
//            int i = 1/0;
//        }catch (Exception e){
//            throw new SystemException(Code.SYSTEM_ERROR, "访问SYSTEM异常", e);
//        }
        if (id == 100) {
            throw new BusinessException(Code.BUSINESS_ERROR, "business错误");
        }
        else if (id == 101) {
            throw new SystemException(Code.SYSTEM_ERROR, "system错误");
        }
        else if (id == 102) {
            int a = 1/0;
        }
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
