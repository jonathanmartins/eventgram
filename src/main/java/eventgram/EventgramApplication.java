package eventgram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eventgram.model.Album;
import eventgram.service.AlbumServiceImpl;
import eventgram.service.InstagramParser;

@SpringBootApplication
public class EventgramApplication implements CommandLineRunner{
	
	@Autowired
	private AlbumServiceImpl albumService;

	public static void main(String[] args) {
        SpringApplication.run(EventgramApplication.class, args);
    }
    
	@Override
	public void run(String... args) throws Exception{
    	/*albumService.deleteAll();
    	
    	InstagramParser insta = new InstagramParser();
    	
    	Album mAlbum = new Album("Meu primeiro album", "This is a test");
    	mAlbum.setCover("https://store-images.s-microsoft.com/image/apps."
    			+ "12939.9007199266247104.04442c96-e9b7-4ee8-ac9a-ab3480429e8e.6856487f-cc4f-"
    			+ "4d9d-b5f3-13eac205abd4?w=191&h=191");
    	

    	mAlbum.setPhotos(insta.parser("https://api.instagram.com/v1/tags/standuppaddle/media/recent?access_token=273211875.b9ea3ff.dcb885f87ae943d59fc6d7d58b303f5d"));

    	albumService.create(mAlbum);
    	
    	Album mAlbum2 = new Album("Mais um album", "Lorem ipsum dolor sit amet");
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
		*/
    }
}