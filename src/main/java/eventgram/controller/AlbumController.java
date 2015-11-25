package eventgram.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eventgram.model.Album;
import eventgram.repository.AlbumRepository;

@Controller
public class AlbumController {

	@Autowired
	private AlbumRepository albumService;
	
	//Lista todos os albuns
	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public String listAll(Model model){
		model.addAttribute("albums", albumService.findAll());
		return "album/index";
	}

	//Salvar o token em algum local se precisar
	@RequestMapping(value = "album/new/#access_token={token}", method = RequestMethod.GET)
	public String newAlbum(@PathVariable(value="token") String token, Model model){
		model.addAttribute("album", new Album());
		model.addAttribute("token", token);
		return "album/form";
	}

	@RequestMapping(value = "album", method = RequestMethod.POST)
	public String saveAlbum(Album album){
		// Recuperar o token, fazer chamada ao instagram, tratar JSON, adicionar urls de fotos no album
		albumService.save(album);
		return "redirect:/album/" + album.getId();
	}
	
	@RequestMapping("album/{id}")
	public String showAlbum(@PathVariable String id, Model model){
		model.addAttribute("album", albumService.findById(id));
		return "/album/show";
	}
	
	@RequestMapping("album/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("album", albumService.findById(id));
		return "album/form";
	}
	
	@RequestMapping("album/delete/{id}")
	public String delete(@PathVariable String id){
		albumService.delete(id);
		return "redirect:/album/index";
	}
}
