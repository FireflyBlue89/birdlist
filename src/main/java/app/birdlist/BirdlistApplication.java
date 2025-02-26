package app.birdlist;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.awt.Desktop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BirdlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirdlistApplication.class, args);
		OpenBrowser("http://localhost:8080");
	}

	@SuppressWarnings("deprecation")
	private static void OpenBrowser(String url){
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	
}
