package org.example;

/**
 * Hello world!
 */
public class App {

    public static void main(final String[] args) {
        App app = new App("App1");

        System.out.println("{ 'app': '%s', 'running': '%s' }".formatted(app.getName(), app.isRunning()));
    }

    private final String name;
    private boolean running = false;

    public App(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(final boolean running) {
        this.running = running;
    }

    public void run() {
        if (isRunning()) {
            throw new IllegalStateException("it is already running");
        }

        this.running = true;
    }

    public void shutdown() {
        if (!isRunning()) {
            throw new IllegalStateException("it is not running");
        }

        this.running = false;
    }

}
