package Task9095;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to console: " + message);
    }
}