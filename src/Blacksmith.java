import java.util.Random;

public class Blacksmith implements Character {
    private int temperature = 0;
    private int hits = 0;
    Random random = new Random();

    // estado inicial
    private State state = new Warming(this);

    public void warmingMetal(int temperature) {
        this.temperature += temperature;
    }

    public void coolingMetal(int temperature) {
        int randomDrop = random.nextInt(temperature);
        this.temperature -= randomDrop;
    }

    public void hittingMetal(int hits) {
        this.hits += hits;// ^^ valor da variavel definida em hitting
    }

    @Override
    public void update() {
        state.execute();
        System.out.println("==============");
    }

    @Override
    public void setState(State state) {
        this.state.leave();
        this.state = state;
        state.enter();
    }

    @Override
    public void printStats(String text) {
        System.out.println("Ferreiro");
        System.out.println(text );
    }
    public int getTemperature() { return temperature; }
    public int getHits() { return hits; }
    public void setTemperature(int temperature) { this.temperature = temperature; }
    public void setHits(int hits) { this.hits = hits; }

}
