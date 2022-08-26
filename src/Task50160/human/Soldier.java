package Task50160.human;

public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    @Override
    public void live() {
        fight();
    }

    public void fight() {
    }
}
