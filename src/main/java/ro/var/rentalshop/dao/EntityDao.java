package ro.var.rentalshop.dao;
import java.util.List;

public interface EntityDao <T>{
    List<T> findAll();
    T findById(int itemId);
    boolean create(T item);
    boolean update(T item);
}
