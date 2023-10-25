package WizardTD.ConfigReader;

import java.util.List;

public class Wave {
    private int duration;
    private double preWavePause;
    private List<Monster> monsters;

    public Wave(int duration, double preWavePause, List<Monster> monsters) {
        this.duration = duration;
        this.preWavePause = preWavePause;
        this.monsters = monsters;
    }

    public int getDuration() {
        return duration;
    }

    public double getPreWavePause() {
        return preWavePause;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}
