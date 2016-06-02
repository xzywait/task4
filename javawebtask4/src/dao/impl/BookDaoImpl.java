package dao.impl;

import java.util.ArrayList;
import java.util.List;

import util.DbUtil;
import vo.Book;
import dao.BookDao;

public class BookDaoImpl implements BookDao {
	
	DbUtil util=new DbUtil();
	
	public void add(Book book) {
		util.getConnection();
		String AddSql="insert into book(bid,name,authors,publisher,publishdate,price) values (?,?,?,?,?,?)";
		util.execSqlWithoutReturn(AddSql, book.getBid(),book.getName(),book.getAuthor(),book.getPublisher()
				,book.getPublishdate(),book.getPrice());
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		util.getConnection();
		String deleteSql="delete from book where bid=?";
		util.execSqlWithoutReturn(deleteSql, id);
		
	}

	public Book findByName(String name) {
		// TODO Auto-generated method stub
		util.getConnection();
		String FindByIdSql="select *from book where name=?";
		System.out.println(name);
		Book book=(Book)util.execSqlWithSingleReturn(FindByIdSql, name);
		
		return book;
	}

	public List<Book> getAll() {
		// TODO Auto-generated method stub
		util.getConnection();
		List<Book> books=new ArrayList<Book>();
		String GetAllSql="select * from book";
		List<Object> list =util.execSqlWithVaryReturn(GetAllSql);
		
		for(int i=0 ;i<list.size();i++){
			books.add((Book)(list.get(i)));
		}
	return books;
	}

	public void update(Book book) {
		util.getConnection();
		String updateSql="UPDATE book SET name=?,authors=?,publisher=?,publishdate=?,price=? WHERE bid = ?";
		
		util.execSqlWithoutReturn(updateSql, book.getName(),book.getAuthor(),book.getPublisher(),book.getPublishdate()
				,book.getPrice(),book.getBid());
		
	}

}
