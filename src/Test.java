public class Test {
    public static void main(String[] args)  {

    //--------------FizzBuzzTest-----------------------
        FizzBuzz fb = new FizzBuzz(20);
        Thread A = new Thread(() -> {
            try {
                fb.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread B = new Thread(() -> {
            try {
                fb.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread C = new Thread(() -> {
            try {
                fb.fizzBuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread D = new Thread(() -> {
            try {
                fb.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        A.start();
        B.start();
        C.start();
        D.start();

        //--------------TimeCounterTest-----------------------
        Thread thread1 = new Thread(TimeCounter::counterSecond);
        Thread thread2 = new Thread(TimeCounter::printMessage);
        thread1.start();
        thread2.start();



    }
}
