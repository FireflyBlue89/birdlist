namespace Kisekae_Database.Models;

public class O_Version{
    public int Id { get; set; }
    public int VersionNumber { get; set;}
    public string? Description { get; set; }
    public byte[] Image { get; set; }
    public string KisekaeCode { get; set; }
    

    public O_Version(){
        Id = 0;
        VersionNumber = 0;
        Description = "";
        Image = [];
        KisekaeCode = "";
    }

    public O_Version(int id, int versionNumber, string? description, byte[] image, string kisekaeCode){
        Id = id;
        VersionNumber = versionNumber;
        Description = description;
        Image = image;
        KisekaeCode = kisekaeCode;
    }
}
