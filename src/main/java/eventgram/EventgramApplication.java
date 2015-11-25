package eventgram;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eventgram.model.Album;
import eventgram.model.Photo;
import eventgram.service.AlbumServiceImpl;

@SpringBootApplication
public class EventgramApplication implements CommandLineRunner{
	
	@Autowired
	private AlbumServiceImpl albumService;

	public static void main(String[] args) {
        SpringApplication.run(EventgramApplication.class, args);
    }
    
	@Override
	public void run(String... args) throws Exception{
    	albumService.deleteAll();
    	
    	Album mAlbum = new Album("Meu primeiro album", "This is a test");
    	mAlbum.setCover("https://store-images.s-microsoft.com/image/apps."
    			+ "12939.9007199266247104.04442c96-e9b7-4ee8-ac9a-ab3480429e8e.6856487f-cc4f-"
    			+ "4d9d-b5f3-13eac205abd4?w=191&h=191");
    	
    	Photo photo = new Photo("https://store-images.s-microsoft.com/image/apps.12939.9007199266247104.04442c96-e9b7-4ee8-ac9a-ab3480429e8e.6856487f-cc4f-4d9d-b5f3-13eac205abd4?w=191&h=191",
    			"GoodVibes", "jonhmbc");
    	Photo photo2 = new Photo("https://store-images.s-microsoft.com/image/apps.12939.9007199266247104.04442c96-e9b7-4ee8-ac9a-ab3480429e8e.6856487f-cc4f-4d9d-b5f3-13eac205abd4?w=191&h=191",
    			"#hashtag", "thiag9");
    	List<Photo> list = new ArrayList<Photo>();
    	list.add(photo);
    	list.add(photo2);
    	mAlbum.setPhotos(list);
    	albumService.create(mAlbum);
    	
    	Album mAlbum2 = new Album("Mais um album", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis tempus tempus velit eget pellentesque. "
    			+ "Curabitur sed enim massa. Vestibulum at dapibus felis. Etiam arcu tellus, ultrices non felis vel, efficitur dapibus tortor.");
    	mAlbum2.setCover("https://store-images.s-microsoft.com/image/apps."
    			+ "12939.9007199266247104.04442c96-e9b7-4ee8-ac9a-ab3480429e8e.6856487f-cc4f-"
    			+ "4d9d-b5f3-13eac205abd4?w=191&h=191");
    	albumService.create(mAlbum2);
    	
    	System.out.println("Albums found with listAll");
    	System.out.println("-------------------------");
    	for (Album album : albumService.findAll()) {
			System.out.println(album.getName());
			System.out.println(album.getId());
		}
		System.out.println();
		
		System.out.println("Customer found with findByFirstName('Meu primerio album'):");
		System.out.println("--------------------------------");
		System.out.println(albumService.findByName("Meu primeiro album").getName());
    }
}
