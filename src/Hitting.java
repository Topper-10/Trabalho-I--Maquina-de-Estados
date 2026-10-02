public class Hitting extends AbstractState<Blacksmith> {

    public Hitting(Blacksmith blacksmith) {
        super(blacksmith);
    }

    @Override
    public void execute() {
        getCharacter().hittingMetal(1);
        getCharacter().coolingMetal(30);
        getCharacter().printStats(" *CLANG* " + getCharacter().getHits() + "/5 (Temperatura caindo para " + getCharacter().getTemperature() + ")");

        if (getCharacter().getHits() >= 5) {
            getCharacter().setState(new Warming(getCharacter()));
        } else if (getCharacter().getTemperature() < 50) {
            getCharacter().setState(new Warming(getCharacter()));
        }
    }

    @Override
    public void enter(){
        System.out.println("Indo para a bigorna");
    }

    @Override
    public void leave() {
        if (getCharacter().getHits() >= 5) {
            System.out.println("Espada pronta!");
        } else if (getCharacter().getTemperature() < 50) {
            System.out.println("O metal esfriou muito!");
        }
    }
}
