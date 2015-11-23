package eventgram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String preCreate(Model model){
		model.addAttribute("album", new Album());
		return "album/new";
	}

	//Cria o album com os atributos passados no form, redireciona para a view show
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String create(@RequestParam String nome, @RequestParam String descricao, Model model){
		Album album = new Album(nome, descricao);
		albumService.save(album);
		model.addAttribute("album", album);
		return "album/show";
	}
}
