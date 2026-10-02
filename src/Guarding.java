public class Guarding extends AbstractState< Guard > {

    public Guarding(Guard guard) {
        super(guard);
    }

    @Override
    public void execute() {
        Guard guard = getCharacter();
        guard.passTime(1);
        guard.printStats("Guardando a entrada (Horas: " + guard.getTime() + ")");

        if (guard.getTime() >= 5) {
            guard.setState(new OffDuty(guard));
        }
    }

    @Override
    public void enter() {
        System.out.println("Hora de cuidar da entrada!");
    }

    @Override
    public void leave() {
        Guard guard = getCharacter();
        System.out.println("Fim de turno");
        guard.setTime(0);
    }
}