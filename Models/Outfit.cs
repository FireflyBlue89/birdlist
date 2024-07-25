namespace Kisekae_Database.Models;

public class Outfit{
    public int Id { get; set; }
    public string Name { get; set; }
    public List<O_Version> Versions { get; set; }

    public Outfit(){
        Id = 0;
        Name = "";
        Versions = [];
    }  

    public Outfit(int id, string name, List<O_Version> versionIds){
        Id = id;
        Name = name;
        Versions = versionIds;
    }
}