//join
sleep() and join() method throws InterruptedException
    //yield() pauses current thread execution but does not release lock and gives jvm hint to execute another thread of same priority
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            //Thread.currentThread().setName("vishal");//possible
            System.out.println(
                "Executing Thread: " + Thread.currentThread().getName()
            );
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.setName("Sujit");
        t2.setName("Sagar");
        t3.setName("Sai");

       // t1.setPriority(10);
       // t2.setPriority(1);
       

        System.out.println("Priority of Thread " + t1.getName() + " = " + t1.getPriority());
        System.out.println("Priority of Thread " + t2.getName() + " = " + t2.getPriority());

        t1.start();
        t1.join();
        t2.start();
        // t2.join();
        t3.start();

        
    }
}

/*
Inter-Thread communication
*/
/*
- Threads can communicate with each other using wait(), notify(), and notifyAll() methods.
1.wait(); -> releases the lock and lets another thread execute
2.notify();
3.notifyAll();
- The above three methods belong to java.lang.Object class. These are the final methods. 

** Note::
- These three methods must be called with a synchronized method or synchronized block. Any thread that calls these methods must have a lock on that object.
    */
class Shared{
    synchronized void methodOne(){
        System.out.println(Thread.currentThread().getName()+" is relasing the lock and going to wait");
    
        try{
            wait();
        }catch(InterruptedException e){
             e.printStackTrace();
        }
         System.out.println(Thread.currentThread().getName()+" got the object lock back and can continue with it's execution");
    }
    
    synchronized void methodTwo(){
        System.out.println(Thread.currentThread().getName()+" Thread inside methodTwo");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        notify();
    }
}

public class Main
{
	public static void main(String[] args) {
	    
	    Shared s = new Shared();
        Thread t1 = new Thread(() -> s.methodOne());
        Thread t2 = new Thread(() -> s.methodTwo());
        t1.setName("first");
        t2.setName("second");
        t1.start();
        t2.start();
    
	//	System.out.println("Hello World");
	}
}

/*
Note ::
When you call sleep() method on a thread, thread goes to sleep with holding the object lock with it. 
But, if you call the wait() method, the thread releases the object lock and goes for sleep. This is the main difference between wait() and sleep() methods.
*/

