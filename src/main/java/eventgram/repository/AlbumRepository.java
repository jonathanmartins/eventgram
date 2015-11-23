package eventgram.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import eventgram.model.Album;

public interface AlbumRepository extends MongoRepository<Album, String>{
	public Album findByName(String name);
	
	@Query("{ '_id' : ?0 }")
	public Album findById(String _id);
}
