package my.testdam.dao;

import org.apache.ibatis.annotations.*;
import my.testdam.domain.Book;

import java.util.List;

@Mapper
public interface BookDao {
//    @Insert("insert into tbl_book values(null,#{type},#{name},#{description})")
    @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
    @Result(property = "id", column = "ids")
    int save(Book book);

    @Update("update tbl_book set type=#{type}, name=#{name}, description=#{description} where ids=#{id}")
    @Result(property = "id", column = "ids")
    int update(Book book);

    @Delete("delete from tbl_book where ids = #{id}")
    @Result(property = "id", column = "ids")
    int delete(Integer id);

    @Select("select * from tbl_book where ids = #{id}")
    @Result(property = "id", column = "ids")
    Book getById(Integer id);

    @Select("select * from tbl_book")
    @Result(property = "id", column = "ids")
    List<Book> getAll();
}
