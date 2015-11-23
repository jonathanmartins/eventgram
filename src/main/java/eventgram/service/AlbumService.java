package eventgram.service;

import java.util.List;

import eventgram.model.Album;

public interface AlbumService {
	public Album create(Album album);
	public Album read(String id);
	public Album findByName(String name);
	public List<Album> listAll();
	public Album update(Album album);
	public boolean delete(Album album);
	public void deleteAll();
}
