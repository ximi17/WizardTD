package WizardTD.ConfigReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ConfigReaderTest {
    @Test
    public void ConfigIsNotNull() {
        ConfigReader config = new ConfigReader();
        // config.readConfig("config.json");
        assertNotNull(config, "config object is not null");
    }
    @Test
    public void PropertiesReadSuccessful() {
        ConfigReader config = new ConfigReader();
        config.readConfig("config.json");

        // Expected values from your config.json
        String expectedLayout = "level2.txt";
        int expectedInitialTowerRange = 96;
        double expectedInitialTowerFiringSpeed = 1.5;
        int expectedInitialTowerDamage = 40;
        int expectedInitialMana = 200;
        int expectedInitialManaCap = 1000;
        int expectedInitialManaGainedPerSecond = 2;
        int expectedTowerCost = 100;
        int expectedManaPoolSpellInitialCost = 100;
        int expectedManaPoolSpellCostIncreasePerUse = 150;
        double expectedManaPoolSpellCapMultiplier = 1.5;
        double expectedManaPoolSpellManaGainedMultiplier = 1.1;

        // Use assertEquals to check if the properties were read correctly
        assertEquals(expectedLayout, config.getMapFile());
        assertEquals(expectedInitialTowerRange, config.getInitialTowerRange());
        assertEquals(expectedInitialTowerFiringSpeed, config.getInitialTowerFiringSpeed());
        assertEquals(expectedInitialTowerDamage, config.getInitialTowerDamage());
        assertEquals(expectedInitialMana, config.getInitialMana());
        assertEquals(expectedInitialManaCap, config.getInitialManaCap());
        assertEquals(expectedInitialManaGainedPerSecond, config.getInitialManaGainedPerSecond());
        assertEquals(expectedTowerCost, config.getTowerCost());
        assertEquals(expectedManaPoolSpellInitialCost, config.getManaPoolSpellInitialCost());
        assertEquals(expectedManaPoolSpellCostIncreasePerUse, config.getManaPoolSpellCostIncreasePerUse());
        assertEquals(expectedManaPoolSpellCapMultiplier, config.getManaPoolSpellCapMultiplier());
        assertEquals(expectedManaPoolSpellManaGainedMultiplier, config.getManaPoolSpellManaGainedMultiplier());

    }

    @Test
    public void WavesMonstersReadSuccessful(){
        ConfigReader config = new ConfigReader();
        config.readConfig("config.json");

        // Test Waves
        List<Wave> waves = config.getWaves();
        assertNotNull(waves, "should not be null");
        assertEquals(3, waves.size());  

        // Test first wave
        Wave firstWave = waves.get(0);
        assertEquals(8, firstWave.getDuration());
        assertEquals(0.5, firstWave.getPreWavePause());

        // Test monsters in first wave
        List<Monster> firstWaveMonsters = firstWave.getMonsters();
        assertEquals(1, firstWaveMonsters.size());  

        Monster firstMonster = firstWaveMonsters.get(0);
        assertEquals("gremlin", firstMonster.getType());
        assertEquals(100, firstMonster.getHp());
        assertEquals(1, firstMonster.getSpeed());
        assertEquals(0.5, firstMonster.getArmour());
        assertEquals(10, firstMonster.getManaGainedOnKill());
        assertEquals(10, firstMonster.getQuantity());

        // Test second wave
        Wave secondWave = waves.get(1);
        assertEquals(5, secondWave.getDuration());
        assertEquals(10, secondWave.getPreWavePause());
        List<Monster> secondWaveMonsters = secondWave.getMonsters();
        assertEquals(1, secondWaveMonsters.size());

        // Test third wave
        Wave thirdWave = waves.get(2);
        assertEquals(5, thirdWave.getDuration());
        assertEquals(10, thirdWave.getPreWavePause());
        List<Monster> thirdWaveMonsters = thirdWave.getMonsters();
        assertEquals(2, thirdWaveMonsters.size());
    }

}
