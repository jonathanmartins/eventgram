package eventgram.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eventgram.model.Album;
import eventgram.repository.AlbumRepository;

@Controller
public class AlbumController {

	@Autowired
	private AlbumRepository albumService;
	
	//Lista todos os albuns
	@RequestMapping("/")
	public String listAll(Model model){
		List<Album> albums = albumService.findAll();
		model.addAttribute("albums", albums);
		return "album/index";
	}

	//Mostra o formulario pra criar um album
	//Salvar o token em algum local se precisar
	@RequestMapping(value="/new/#access_token={token}", method = RequestMethod.GET)
	public String showFormNew(@PathVariable(value="token") String token, Model model){
		
		// Salvar o token se necessario
		
		model.addAttribute("album", new Album());
		model.addAttribute("token", token);
		return "album/new";
	}

	//Cria o album com os atributos passados no form, redireciona para a view show
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String create(@RequestParam String name, @RequestParam String description, Model model){
		Album album = new Album(name, description);
		
		// Recuperar o token, fazer chamada ao instagram, tratar JSON, adicionar urls de fotos no album
		
		albumService.save(album);
		model.addAttribute("album", album);
		return "album/show";
	}
}
