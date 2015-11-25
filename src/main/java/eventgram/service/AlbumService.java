package eventgram.service;

import java.util.List;

import eventgram.model.Album;

public interface AlbumService {
	public Album create(Album album);
	public Album read(String id);
	public Album findByName(String name);
	public Album findById(String id);
	public List<Album> findAll();
	public Album update(String id);
	public void delete(String id);
	public void deleteAll();
}
