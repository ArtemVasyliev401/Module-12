import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz {
    private volatile int n;
    public static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();
    public static volatile AtomicInteger number = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;

    }

    public void fizz() throws InterruptedException {
        while (number.get()< n){
            if(number.get() % 3 == 0 && number.get() % 5 != 0){
                queue.add("fizz");
                number.incrementAndGet();
            }
        }
    }

    public void buzz() throws InterruptedException{
        while (number.get()< n){
            if(number.get() % 3 != 0 && number.get() % 5 == 0){
                queue.add("buzz");
                number.incrementAndGet();
            }
        }
    }

    public void fizzBuzz() throws InterruptedException{
        while (number.get()< n){
            if(number.get() % 3 == 0 && number.get() % 5 == 0){
                queue.add("fizzBuzz");
                number.incrementAndGet();
              }
            }
        }


    public void number() throws InterruptedException{
        while (number.get()< n){
            if(number.get() % 3 != 0 && number.get() % 5 != 0){
                queue.add(String.valueOf(number.get()));
                number.incrementAndGet();

            }
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }

        }

    }

}



//    public static void main(String[] args) {
//        for (int i = 0; i < number.get(); i++) {
//            if(i % 3 == 0 && i % 5 !=0){
//                System.out.println("fizz");
//            }else if ( i % 15 == 0){
//                System.out.println("fizzbuzz");
//            } else {
//                System.out.println(i);
//            }
//        }
//        ExecutorService service = Executors.newFixedThreadPool(3);
//        service.submit(() -> {
//            while (number.get() > 0) {
//                if (number.get() % 3 == 0 && number.get() % 5 != 0) {
//                    //System.out.println("fizz");
//                    queue.add("fizz");
//                    number.decrementAndGet();
//                    Thread.currentThread().notifyAll();
//                } else {
//                    try {
//                        Thread.currentThread().wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                }
//            }
//        });
//
//        service.submit(() -> {
//            while (number.get() > 0) {
//                if (number.get() % 3 == 0 && number.get() % 5 == 0) {
//                    queue.add("fizzbuzz");
//                    number.decrementAndGet();
//                    Thread.currentThread().notifyAll();
//                } else {
//                    try {
//                        Thread.currentThread().wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                }
//            }
//        });
//
//
//        service.submit(() -> {
//            while (number.get() > 0) {
//                if (number.get() % 3 != 0 && number.get() % 5 != 0) {
//                    queue.add(String.valueOf(number.get()));
//                    number.decrementAndGet();
//                    Thread.currentThread().notifyAll();
//                } else {
//                    try {
//                        Thread.currentThread().wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                }
//            }
//        });
//
//        service.submit(() ->{
//            while (true){
//                if(queue.isEmpty()){
//                    Thread.sleep(1000);
//                }else {
//                    while (!queue.isEmpty()){
//                        System.out.println(queue.poll());
//                    }
//                }
//            }
//        });
//    }

