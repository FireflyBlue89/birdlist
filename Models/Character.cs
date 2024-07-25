namespace Kisekae_Database.Models;

public class Character{
    public int Id { get; set; }
    public string Name { get; set; }
    public List<Outfit> Outfits { get; set; }

    public Character(){
        Id = 0;
        Name = "";
        Outfits = [];
    }  

    public Character(int id, string name, List<Outfit> outfitIds){
        Id = id;
        Name = name;
        Outfits = outfitIds;
    }
}
