public class OffDuty extends AbstractState< Guard > {

    public OffDuty(Guard guard) {
        super(guard);
    }

    @Override
    public void execute() {
        Guard guard = getCharacter();
        guard.passTime(1);
        guard.printStats("Fora do turno (Horas: " + guard.getTime()+ ")");


        if (guard.getTime() >= 8 ) {
            guard.setState(new Marching(guard));
        }
    }

    @Override
    public void enter() {
        System.out.println("Hora de descansar!!");
    }

    @Override
    public void leave() {
        Guard guard = getCharacter();
        System.out.println("Descanso concluído!");
        guard.setTime(0);
    }
}