public class Guard implements Character {
    private int march = 0;
    private int time = 0;

    //estado inicial
    private State<Guard> state = new Marching(this);

    public void marchAround(int march) {
        this.march += march;
    }

    public void passTime(int time) {
        this.time += time;
    }

    @Override
    public void update() {
        state.execute();
        System.out.println("==============");
    }

    @Override
    public void setState(State state) {
        this.state.leave();
        this.state = (State<Guard>) state;
        state.enter();
    }

    @Override
    public void printStats(String text) {
        System.out.println("Guarda");
        System.out.println(text);
    }
    public int getTime() { return time; }
    public int getMarch() { return march; }
    public void setTime(int time) { this.time = time; }
    public void setMarch(int march) { this.march = march; }
}