package eventgram.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import eventgram.model.Album;
import eventgram.model.Photo;
import eventgram.service.AlbumService;
import eventgram.service.InstagramParser;

@Controller
@SessionAttributes("album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	
	//Lista todos os albuns
	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public String listAll(Model model){
		model.addAttribute("albums", albumService.findAll());
		return "album/index";
	}

	//Salvar o token em algum local se precisar
	@RequestMapping(value = "albums/new", method = RequestMethod.GET)
	public String newAlbum(Model model){
		model.addAttribute("album", new Album());
		return "album/form_new";
	}
	
	@RequestMapping("albums/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		model.addAttribute("album", albumService.findById(id));
		return "album/form_edit";
	}

	// Fazer chamada ao instagram, tratar JSON, adicionar urls de fotos no album
	@RequestMapping(value = "album", method = RequestMethod.POST)
	public String saveAlbum(@ModelAttribute("album") Album album){
		List<Photo> photos = new ArrayList<>();
		InstagramParser insta = new InstagramParser();
		String tag = album.getTag();
		photos = insta.parser("https://api.instagram.com/v1/tags/"+ tag +"/media/recent?access_token=273211875.b9ea3ff.dcb885f87ae943d59fc6d7d58b303f5d");
		album.setPhotos(photos);
		album.setCover(photos.get(0).getLink());
		albumService.create(album);
		return "redirect:/albums/" + album.getId();
	}
	
	@RequestMapping("albums/{id}")
	public String showAlbum(@PathVariable String id, Model model){
		model.addAttribute("album", albumService.findById(id));
		return "/album/show";
	}
		
	@RequestMapping("albums/delete/{id}")
	public String delete(@PathVariable String id){
		albumService.delete(id);
		return "redirect:/albums";
	}
}
