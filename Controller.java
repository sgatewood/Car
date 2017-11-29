// Change CAR_SPEED on line 43

import java.util.ArrayList;

class Controller{ // Bloop bloop don't worry about this stuff
  public static boolean STOP = false;
  public static int INDEX = 0;
  public static int SPEED = 50; // Change to set car speed relative to mind wave data

  public static void main(String[] args) {
    Thread t = new Thread(new Clock());
    t.start();
  }


   static class Clock implements Runnable{

     // Loop speed:
     public static int speed = 100; // 1000 = loop once per second, 2000 = twice per second, etc
     // (so 100 is 10 times a second)

     ArrayList<Integer> concentration_values = Reader.getConcentrationVals();
     int counter = 0;
     boolean reboot_file = true;
     // If this is true, the file will refresh every 5 seconds.
     // If this is false, the file will only load at the beginning.

    // Ignore this stuff
     public void run(){
       Gui car = new Gui();
       while(!Controller.STOP){


         //------------------------------------------------------------------------------
         // TYPE CODE HERE
         // (Indentation, whitespace, etc doesn't matter. Semicolons after every line.)
            if(counter % 10 == 0){ // Every 1 second (if speed is set at 100)...
              Controller.INDEX++;
              if(Controller.INDEX % 5 == 0 && reboot_file){
                concentration_values = Reader.getConcentrationVals();
              }
            }

            try{
              int x = concentration_values.get(Controller.INDEX) * Controller.SPEED/100;
              car.setSpeedText(x);
              car.right(x);
            }catch(IndexOutOfBoundsException e){
              // do nothing
            }


             Clock.speed = 100; // If you wanna change the loop speed within the loop (e.g. make it loop faster/slower)

             //System.out.println("Looped!"); // Remove this if you want it to loop really fast (printing slows things down a LOT)
             counter++;
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
