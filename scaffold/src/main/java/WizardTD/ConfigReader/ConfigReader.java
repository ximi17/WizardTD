package WizardTD.ConfigReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigReader {
    private String mapFile;
    private char[][] map;
    private List<Wave> waves;
    private int initialTowerRange;
    private double initialTowerFiringSpeed;
    private int initialTowerDamage;
    private int initialMana;
    private int initialManaCap;
    private int initialManaGainedPerSecond;
    private int towerCost;
    private int manaPoolSpellInitialCost;
    private int manaPoolSpellCostIncreasePerUse;
    private double manaPoolSpellCapMultiplier;
    private double manaPoolSpellManaGainedMultiplier;

    public void readConfig(String configFilePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(configFilePath));
            JSONObject jsonObject = (JSONObject) obj;

            // Get layout file name
            this.mapFile = (String) jsonObject.get("layout");

            // Read layout file to get map layout
            readLayoutFile(mapFile);
            this.waves = new ArrayList<Wave>();
            // read waves
            JSONArray jsonWaves = (JSONArray) jsonObject.get("waves");
            for (Object o : jsonWaves) {
                JSONObject jsonWave = (JSONObject) o;
                int duration = ((Long) jsonWave.get("duration")).intValue();
                double preWavePause = Double.valueOf(jsonWave.get("pre_wave_pause").toString());
                

                // Read monsters in this wave
                List<Monster> monsters = new ArrayList<>();
                JSONArray jsonMonsters = (JSONArray) jsonWave.get("monsters");
                for (Object m : jsonMonsters) {
                    JSONObject jsonMonster = (JSONObject) m;
                    String type = (String) jsonMonster.get("type");
                    int hp = ((Long) jsonMonster.get("hp")).intValue();
                    double speed = Double.valueOf(jsonMonster.get("speed").toString());
                    double armour = (double) jsonMonster.get("armour");
                    int manaGainedOnKill = ((Long) jsonMonster.get("mana_gained_on_kill")).intValue();
                    int quantity = ((Long) jsonMonster.get("quantity")).intValue();

                    monsters.add(new Monster(type, hp, speed, armour, manaGainedOnKill, quantity));
                }

                this.waves.add(new Wave(duration, preWavePause, monsters));
            }

            // read other properties
            this.initialTowerRange = ((Long) jsonObject.get("initial_tower_range")).intValue();
            this.initialTowerFiringSpeed = (double) jsonObject.get("initial_tower_firing_speed");
            this.initialTowerDamage = ((Long) jsonObject.get("initial_tower_damage")).intValue();
            this.initialMana = ((Long) jsonObject.get("initial_mana")).intValue();
            this.initialManaCap = ((Long) jsonObject.get("initial_mana_cap")).intValue();
            this.initialManaGainedPerSecond = ((Long) jsonObject.get("initial_mana_gained_per_second")).intValue();
            this.towerCost = ((Long) jsonObject.get("tower_cost")).intValue();
            this.manaPoolSpellInitialCost = ((Long) jsonObject.get("mana_pool_spell_initial_cost")).intValue();
            this.manaPoolSpellCostIncreasePerUse = ((Long) jsonObject.get("mana_pool_spell_cost_increase_per_use")).intValue();
            this.manaPoolSpellCapMultiplier = (double) jsonObject.get("mana_pool_spell_cap_multiplier");
            this.manaPoolSpellManaGainedMultiplier = (double) jsonObject.get("mana_pool_spell_mana_gained_multiplier");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readLayoutFile(String layoutFilePath) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(layoutFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rows = lines.size();
        int cols = lines.get(0).length();
        this.map = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.map[i][j] = lines.get(i).charAt(j);
            }
        }
    }

    public String getMapFile(){
        return mapFile;
    }
    public char[][] getMap() {
        return map;
    }
    public List<Wave> getWaves(){
        return waves;
    }
    public int getInitialTowerRange() {
        return initialTowerRange;
    }
    
    public double getInitialTowerFiringSpeed() {
        return initialTowerFiringSpeed;
    }
    
    public int getInitialTowerDamage() {
        return initialTowerDamage;
    }
    
    public int getInitialMana() {
        return initialMana;
    }
    
    public int getInitialManaCap() {
        return initialManaCap;
    }
    
    public int getInitialManaGainedPerSecond() {
        return initialManaGainedPerSecond;
    }
    
    public int getTowerCost() {
        return towerCost;
    }
    
    public int getManaPoolSpellInitialCost() {
        return manaPoolSpellInitialCost;
    }
    
    public int getManaPoolSpellCostIncreasePerUse() {
        return manaPoolSpellCostIncreasePerUse;
    }
    
    public double getManaPoolSpellCapMultiplier() {
        return manaPoolSpellCapMultiplier;
    }
    
    public double getManaPoolSpellManaGainedMultiplier() {
        return manaPoolSpellManaGainedMultiplier;
    }
}