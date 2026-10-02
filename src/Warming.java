public class Warming extends AbstractState< Blacksmith > {

    public Warming(Blacksmith blacksmith) {
        super(blacksmith);
    }

    @Override
    public void execute() {
        getCharacter().warmingMetal(40);
        getCharacter().printStats("Aquecendo metal (Calor: " + getCharacter().getTemperature() + ")");

        if (getCharacter().getTemperature() >= 100) {
            getCharacter().setState(new Hitting(getCharacter()));
        }
    }

    @Override
    public void enter() {
        if (getCharacter().getHits() >= 5) {
            System.out.println("Fazendo a próxima");
            getCharacter().setHits(0);
            getCharacter().setTemperature(0);
        } else if (getCharacter().getTemperature() < 50) {
            System.out.println("De volta ao fogo");
        }
    }

    @Override
    public void leave() {
        System.out.println("Metal quente!");
    }
}
