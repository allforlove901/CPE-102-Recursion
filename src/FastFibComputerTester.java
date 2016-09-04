public class FastFibComputerTester
{
   public static void main(String[] args)
   {  
      FastFibComputer ffc = new FastFibComputer();
      System.out.println(ffc.fib(50));
      System.out.println("Expected: 12586269025");
      System.out.println(ffc.fib(90));
      System.out.println("Expected: 2880067194370816120");
   }
}