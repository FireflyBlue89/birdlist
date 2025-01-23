package app.birdlist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import app.birdlist.repository.CharacterRepository;
import app.birdlist.entity.Characters;
import app.birdlist.object.InfoCharacter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;



@Controller
public class CharacterController {

	@Autowired
	private CharacterRepository charaBase;

	@GetMapping("/")
	public String MainPage(Model mainPageModel) {
		if(charaBase.count() == 0){
			mainPageModel.addAttribute("anyChar", false);
		}else{
			mainPageModel.addAttribute("anyChar", true);
			List<InfoCharacter> listChar = new ArrayList<>();
			for (String[] nd : charaBase.withoutImage()) {
				InfoCharacter chara = new InfoCharacter();
				chara.setName(nd[0]);
				chara.setDescription(nd[1]);
				listChar.add(chara);
			}

			mainPageModel.addAttribute("listChar", listChar);
		}

		mainPageModel.addAttribute("newChar", new InfoCharacter());
		return "home.html";
	}

	@PostMapping("/addChar")
	public RedirectView postNewChar(@ModelAttribute InfoCharacter newChar, @RequestParam("profile") MultipartFile profile_pic) throws IOException {
		if(newChar != null && charaBase.findById(newChar.getName()).isEmpty()){
			byte[] allB = profile_pic.getBytes();
			Characters chara = new Characters();
			chara.setName(newChar.getName());
			chara.setDescription(newChar.getDescription());
			chara.setProfile_image(allB);
			System.out.println(allB.length);
			for (byte b : allB) {
				System.out.print(b);
			}
			System.out.println(allB);
			charaBase.save(chara);
			charaBase.flush();
		}else{
			System.out.println("Exist or error");
		}
		return new RedirectView("/");
	}

	@PostMapping("/deleteChar/{id}")
	public RedirectView postMethodName(@PathVariable String id) {
		if(!charaBase.findById(id).isEmpty()){
			charaBase.deleteById(id);
			charaBase.flush();
		}else{
			System.out.println("Exist or error");
		}		

		return new RedirectView("/");
	}
	
	
}
