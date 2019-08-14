package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.PostDao;
import museum.entity.Post;
import org.springframework.stereotype.Repository;

/**
 * DAO implementation for Post entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Repository
public class PostDaoImpl extends ElementDaoImpl<Post> implements PostDao {
    public PostDaoImpl() {
        super(Post.class);
    }
}
