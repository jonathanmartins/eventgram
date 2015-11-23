package eventgram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eventgram.model.Album;
import eventgram.repository.AlbumRepository;

public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	public AlbumServiceImpl(AlbumRepository albumRepository){
		this.albumRepository = albumRepository;
	}

	public Album create(Album album) {
		//album.setId(UUID.randomUUID().toString());
		
		return albumRepository.save(album);
	}

	public Album read(String id) {
		return albumRepository.findById(id);
	}

	public List<Album> listAll() {
		return albumRepository.findAll();
	}

	public Album update(Album album) {
		Album existingAlbum = albumRepository.findByName(album.getName());
		
		//Não achei muito certo retornar null, tirado de um tutorial
		if (existingAlbum == null){
			return null;
		}
		
		//Não faz muito sentido
		existingAlbum.setName(album.getName());
		existingAlbum.setDescription(album.getDescription());
		
		//return albumRepository.save(album);
		return albumRepository.save(existingAlbum);
	}

	public boolean delete(Album album) {
		Album existingAlbum = albumRepository.findByName(album.getName());
		
		//Não achei muito certo retornar null, tirado de um tutorial
		if (existingAlbum == null) {
			return false;
		}
		
		//Por q não deletar o próprio album do parametro?
		albumRepository.delete(existingAlbum);
		return true;
	}
	
	public void deleteAll(){
		albumRepository.deleteAll();
	}

	@Override
	public Album findByName(String name) {
		return albumRepository.findByName(name);
	}
}