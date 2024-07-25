using Kisekae_Database.Models;
using CsvHelper;
using System.Globalization;

namespace Kisekae_Database.Processing;

public static class DatabaseProcessing{
    private static List<Character> DatabaseCharacters = [];

    private static void LoadCharacters(){
        if(File.Exists("save.kdatabase")){
            using StreamReader reader = new("save.kdatabase");
            using CsvReader csv = new(reader, CultureInfo.InvariantCulture);
            DatabaseCharacters = csv.GetRecords<Character>().ToList();
        }else{
            DatabaseCharacters = [];
        }
    }

    public static List<Character> GetCharacters(){
        if(DatabaseCharacters.Count == 0){
            LoadCharacters();
        }
        
        return DatabaseCharacters;
    } 

    public static Character? GetCharacter(int id){
        return DatabaseCharacters.FirstOrDefault(c => c.Id == id);
    } 

    public static void AddCharacter(string characterName){
        int id = 0;
        bool confirm = false;
        while(!confirm){
            id++;
            confirm = true;
            foreach(Character c in DatabaseCharacters){
                if(c.Id == id){
                    confirm = false;
                    break;
                }
            }
        }
        
        Character character = new(id, characterName, []);

        if(DatabaseCharacters.Contains(character)){
            return;
        }

        DatabaseCharacters.Add(character);
        NewSave();
    }

    private static void NewSave(){
        if(File.Exists("save.kdatabase")){
            File.Delete("save.kdatabase");
        }

        using StreamWriter writer = new("save.kdatabase");
        using CsvWriter csv = new(writer, CultureInfo.InvariantCulture);
        csv.WriteRecords(DatabaseCharacters);
    }
}
