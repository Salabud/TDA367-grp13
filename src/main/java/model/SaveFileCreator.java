package Model;

import Model.Ants.WorkerAnt;
import Model.World.Tile;
import Model.World.World;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFileCreator {
    private static SaveFileCreator INSTANCE;

    private SaveFileCreator(){
    }

    public void save(World world, String saveName){
        JSONObject json = new JSONObject();
        JSONArray tileArray = new JSONArray();
        JSONArray entityArray = new JSONArray();
        for (Tile tile : world.getTiles()){
            tileArray.put(tile.toJSON());
        }
        for (Entity entity : world.getEntities()){
            //TODO Await refactoring of Entity
            entityArray.put(entity.toJSON());
        }

        json.put("tiles", tileArray);
        json.put("entities", entityArray);
        try(FileWriter fileWriter = new FileWriter(saveName + ".json")) {
            fileWriter.write(json.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SaveFileCreator getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SaveFileCreator();
        }
        return INSTANCE;
    }

}
