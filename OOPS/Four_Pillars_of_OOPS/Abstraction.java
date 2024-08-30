public class Abstraction {
    // Abstract class
    public static abstract class Car {
        public abstract void stop();
    }

    // Concrete class
    public static class Honda extends Car {
        // Hiding implementation details
        @Override
        public void stop() {
            System.out.println("Honda::Stop");
            System.out.println(
                    "Mechanism to stop the car using break");
        }
    }

    public static void main(String args[]) {
        Car obj = new Honda(); // Car object =>contents of Honda
        obj.stop(); // call the method
    }
}
