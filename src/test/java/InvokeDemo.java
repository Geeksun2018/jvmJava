public class InvokeDemo implements Runnable{

    public static void main(String[] args) {
        new InvokeDemo().test();
    }

    private void test() {
        InvokeDemo.staticMethod();
        InvokeDemo demo = new InvokeDemo();
        demo.instanceMethod();
        super.equals(null);
        this.run();
        ((Runnable)demo).run();

    }

    private void instanceMethod() {

    }

    public static void staticMethod() {

    }

    @Override
    public void run() {

    }
}
