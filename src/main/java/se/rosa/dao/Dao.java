package se.rosa.dao;

/**
 * Created by Robert on 2019-06-14.
 */
public interface Dao<T> {

	void create(T t);

	T read(Long id);

	T delete(Long id);

	T update(T t);
}
