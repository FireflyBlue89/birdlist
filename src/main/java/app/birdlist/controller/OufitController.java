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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import app.birdlist.entity.Characters;
import app.birdlist.entity.Outfits;
import app.birdlist.entity.Version;
import app.birdlist.object.InfoOutfit;
import app.birdlist.repository.CharacterRepository;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/char")
public class OufitController {
    
	@Autowired
	private CharacterRepository charaBase;

	@GetMapping("/")
	public RedirectView DefaultPage(Model mainPageModel) {
		return new RedirectView("/");
	}

	@GetMapping("/{charName}")
	public String OutfitPage(@PathVariable String charName, Model outfitModel) {
		if(charName != null && !charaBase.findById(charName).isEmpty()){
            Characters character = charaBase.findById(charName).get();
			outfitModel.addAttribute("charName", character.getName());
            outfitModel.addAttribute("charDesc", character.getDescription());
            outfitModel.addAttribute("charImage", character.getProfile_image());


			List<Outfits> outfits = character.getOutfits();
			List<InfoOutfit> charOutfits = new ArrayList<>();
			InfoOutfit temp;
			Version temp2;

			for(Outfits out : outfits){
				temp = new InfoOutfit();
				temp2 = out.getVersions().getLast();

				temp.setOut_name(out.getName());
				temp.setVer_id(temp2.getId());
				temp.setVer_desc(temp2.getChangelog());
				temp.setVer_date(temp2.getDate());
				temp.setVer_code(temp2.getVer_code());
				charOutfits.add(temp);
			}
			temp = null;
			temp2 = null;

            outfitModel.addAttribute("charOutfits", charOutfits);
            outfitModel.addAttribute("newOutfit", new InfoOutfit());
			return "outfit.html";
		}else{
			System.out.println("Exist or error");
		}
		return null;
	}
	
	@Transactional
	@PostMapping("/{charName}/addOutfit")
	public RedirectView postNewOutfit(@PathVariable String charName, @ModelAttribute InfoOutfit newOutfit, @RequestParam("outfit_image") MultipartFile outfit_pic) throws IOException {
		if(newOutfit != null && !charaBase.findById(charName).isEmpty() ){
			byte[] allB = outfit_pic.getBytes();
			Characters chara = charaBase.findById(charName).get();
			Outfits out = new Outfits();
			Version ver = new Version();
			List<Outfits> outs = chara.getOutfits();
			List<Version> vers = new ArrayList<>();


			ver.setTitle("Initial Version");
			ver.setDate(newOutfit.getVer_date());
			ver.setCharacter_image(allB);
			ver.setChangelog(newOutfit.getVer_desc());
			ver.setVer_code(newOutfit.getVer_code());
			ver.setNext(-1);
			ver.setPrev(-1);

			vers.add(ver);

			out.setName(newOutfit.getOut_name());
			out.setVersions(vers);
			
			outs.add(out);

			chara.setOutfits(outs);
		}else{
			System.out.println("Exist or error");
		}
		return new RedirectView("/char/" + charName);
	}

	@Transactional
	@PostMapping("/deleteOutfit/{name}/{outfit}")
	public RedirectView removeOutfit(@PathVariable String name, @PathVariable String outfit) {
		if(!charaBase.findById(name).isEmpty()){
			List<Outfits> outfits = charaBase.findById(name).get().getOutfits();
			if(outfits.size() > 0){
				for(Outfits out : outfits){
					if(out.getName().equals(outfit)){
						outfits.remove(out);
						break;
					}
				}
			}
		}else{
			System.out.println("Exist or error");
		}		

		return new RedirectView("/char/" + name);
	}
}
