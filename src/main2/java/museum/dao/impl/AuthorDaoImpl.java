package museum.dao.impl;

import museum.dao.AuthorDao;
import museum.dao.ElementDaoImpl;
import museum.entity.Author;
import org.springframework.stereotype.Repository;

/**
 * Repository for Author logic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Repository
public class AuthorDaoImpl extends ElementDaoImpl<Author> implements AuthorDao {
  public AuthorDaoImpl() {
    super(Author.class);
  }
}
