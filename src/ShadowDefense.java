import bagel.AbstractGame;
import bagel.Input;
import bagel.Window;
import bagel.map.TiledMap;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

public class ShadowDefense extends AbstractGame{

    private static int currentLevel=1;
    private static int maxLevel;
    private static HashMap<Integer,String>levelMaps=new HashMap<>();
    private TiledMap map;

    private static TiledMap loadMap(int currentLevel){
        return new TiledMap(levelMaps.get(currentLevel));
    }

    public ShadowDefense(){
        this.map = loadMap(currentLevel);
    }

    public static void main(String[] args){
        File dir=new File("res/levels");
        File[] maps=dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".tmx");
            }
        });
        maxLevel=maps.length;
        for(int i=0;i<maxLevel;i++){
            levelMaps.put(i+1,maps[i].toString());
        }
        new ShadowDefense().run();
    }

    @Override
    public void update(Input input){
     map.draw(0,0,0,0, Window.getWidth(), Window.getHeight());
    }

}
