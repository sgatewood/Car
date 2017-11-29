class Controller{ // Bloop bloop don't worry about this stuff
  public static void main(String[] args) {
    Thread t = new Thread(new Clock());
    t.start();
  }
   static class Clock implements Runnable{

     // Loop speed:
     public static int speed = 100; // 1000 = loop once per second, 2000 = twice per second, etc.
     // (so 100 is 10 times a second)

    // Ignore this stuff
     public void run(){
       Gui car = new Gui();
       while(true){


         //------------------------------------------------------------------------------
         // TYPE CODE HERE
         // (Indentation, whitespace, etc doesn't matter. Semicolons after every line.)
             car.right(2); // move right 2
             car.down(2); // move down 2

             int x = 2;
             car.right(x);

             Clock.speed = 100; // If you wanna change the loop speed within the loop (e.g. make it loop faster/slower)

             System.out.println("Looped!"); // Remove this if you want it to loop really fast (printing slows things down a LOT)
         //-----------------------------------------------------------------------------


         // Ignore this stuff
         try{
           Thread.sleep(Clock.speed);
         }catch(InterruptedException e){
           System.out.println("Something went wrong.");
         }
       }
     }
   }
}
