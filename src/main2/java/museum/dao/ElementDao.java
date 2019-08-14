package museum.dao;

import java.util.List;

public interface ElementDao<T> {
  List<T> findAll();

  T findById(Long id);

  void save(T element);

  T update(T element);

  Boolean deleteById(Long id);
}
