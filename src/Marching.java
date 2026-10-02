public class Marching extends AbstractState< Guard > {

    public Marching(Guard guard) {
        super(guard);
    }

    @Override
    public void execute() {
        Guard guard = getCharacter();
        guard.marchAround(1);
        guard.printStats("Marchando ao redor do castelo(Voltas: " + guard.getMarch() + ")");

        if (guard.getMarch() >= 5) {
            guard.setState(new Guarding(guard));
            getCharacter().setMarch(0);
        }
    }

    @Override
    public void enter() {
        System.out.println("Hora de marchar!");
    }

    @Override
    public void leave() {
        System.out.println("Patrulha completa!");
    }
}