package eventgram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventgram.model.Album;
import eventgram.repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	private AlbumRepository albumRepository;
	
	public AlbumServiceImpl(){
	}
	
	@Autowired
	public void setAlbumRepository(AlbumRepository repo){
		this.albumRepository = repo;
	}

	public Album create(Album album) {
		return albumRepository.save(album);
	}

	public Album read(String id) {
		return albumRepository.findById(id);
	}

	public List<Album> findAll() {
		return albumRepository.findAll();
	}

	public Album update(String id) {
		Album existingAlbum = albumRepository.findById(id);
		
		if (existingAlbum == null){
			return null;
		}
		
		return albumRepository.save(existingAlbum);
	}

	public void delete(String id) {
		Album existingAlbum = albumRepository.findById(id);
		albumRepository.delete(existingAlbum);
	}
	
	public void deleteAll(){
		albumRepository.deleteAll();
	}

	public Album findByName(String name) {
		return albumRepository.findByName(name);
	}
	
	public Album findById(String id){
		return albumRepository.findById(id);
	}
}