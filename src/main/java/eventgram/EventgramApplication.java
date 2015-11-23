package eventgram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eventgram.model.Album;
import eventgram.repository.AlbumRepository;

@SpringBootApplication
public class EventgramApplication implements CommandLineRunner{
	
	@Autowired
	private AlbumRepository albumService;

	public static void main(String[] args) {
        SpringApplication.run(EventgramApplication.class, args);
    }
    
	@Override
	public void run(String... args) throws Exception{
    	albumService.deleteAll();
    	
    	albumService.save(new Album("Meu primeiro album", "This is a test"));
    	
    	System.out.println("Albums found with listAll");
    	System.out.println("-------------------------");
    	for (Album album : albumService.findAll()) {
			System.out.println(album.getName());
		}
		System.out.println();
		
		System.out.println("Customer found with findByFirstName('Meu primerio album'):");
		System.out.println("--------------------------------");
		System.out.println(albumService.findByName("Meu primeiro album").getName());
    }
}
