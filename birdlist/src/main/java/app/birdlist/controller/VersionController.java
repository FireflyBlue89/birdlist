package app.birdlist.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import app.birdlist.entity.Outfits;
import app.birdlist.entity.Version;
import app.birdlist.object.InfoVersion;
import app.birdlist.repository.OutfitRepository;
import app.birdlist.repository.VersionRepository;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/version")
public class VersionController {

    @Autowired
    private VersionRepository verBase;

    @Autowired
    private OutfitRepository outfitBase;

    @GetMapping("/")
	public RedirectView DefaultPage(Model mainPageModel) {
		return new RedirectView("/");
	}

    @GetMapping("/{verId}")
    public String checkVersion(@PathVariable Integer verId, Model vModel){ 
        if(verBase.findById(verId).isPresent()){
            Version ver = verBase.findById(verId).get();
            InfoVersion verInfo = new InfoVersion(ver.getId(), ver.getCharName(), ver.getTitle(), ver.getDate(), ver.getChangelog(), ver.getVer_code(), ver.getPrev(), ver.getNext());

            vModel.addAttribute("version", verInfo);
            ver = null;
            verInfo = null;
            return "version.html";
        }else{
            return null;
        }

    }    

    @Transactional
    @PostMapping("/addVersion/{charName}/{outfitId}")
    public RedirectView newVersion(@PathVariable String charName, @PathVariable Integer outfitId, @ModelAttribute InfoVersion newVersion, @RequestParam("version_image") MultipartFile outfit_pic) throws IOException {
        Outfits targetOutfit = outfitBase.findById(outfitId).get();
        Version newVer = new Version();
        Version lastVer = null;

        if(targetOutfit != null && newVersion != null){    
            newVer.setCharName(charName);        
            newVer.setTitle(newVersion.getTitle());
            newVer.setChangelog(newVersion.getChangelog());
            newVer.setVer_code(newVersion.getCode());
            newVer.setDate(newVersion.getDate());
            newVer.setCharacter_image(outfit_pic.getBytes());
            
            newVer.setNext(-1);

            lastVer = targetOutfit.getVersions().get(targetOutfit.getVersions().size() - 1);
            if(lastVer != null){
                newVer.setPrev(lastVer.getId());                

                List<Version> temp = targetOutfit.getVersions();
                temp.add(newVer);
                targetOutfit.setVersions(temp);
                temp = null;
                
                verBase.save(newVer);
                verBase.flush();

                lastVer.setNext(newVer.getId());
            }
        }else{
            System.out.println("Empty");
        }
        
        newVer = null;
        lastVer = null;
        return new RedirectView("/char/" + charName);
    }
    
}
