import java.util.List;

/**
 * Created by andrzej on 23.07.17.
 */
public interface BooksDAO {
	List<Books> get();
	void add(Books books);
	void delete(Books books);
	void update(Books books);


}
