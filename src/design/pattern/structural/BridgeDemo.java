package design.pattern.structural;
/*					
					      -------Vehicle----
					      /                   \
					Bus                       Bike
					/   \                 /          \
			Produce Bus  Assemble Bus  AssembleBike  Produce Bike                           */

/*					
			-------Vehicle-----------------------------------------------Workshop 
			/                   \										/      \
			Bus                 Bike                          	  Produce   Assemble       */

abstract class Vehicle { 
    protected Workshop produce; 
    protected Workshop assemble; 
  
    protected Vehicle(Workshop produce, Workshop assemble) 
    { 
        this.produce = produce; 
        this.assemble = assemble; 
    } 
  
    abstract public void manufacture(); 
} 
  
// Refine abstraction 1 in bridge pattern 
class Car extends Vehicle { 
    public Car(Workshop workShop1, Workshop workShop2) 
    { 
        super(workShop1, workShop2); 
    } 
  
    @Override
    public void manufacture() 
    { 
        System.out.print("Car "); 
        produce.work(); 
        assemble.work(); 
    } 
} 
  
// Refine abstraction 2 in bridge pattern 
class Bike extends Vehicle { 
    public Bike(Workshop workShop1, Workshop workShop2) 
    { 
        super(workShop1, workShop2); 
    } 
  
    @Override
    public void manufacture() 
    { 
        System.out.print("Bike "); 
        produce.work(); 
        assemble.work(); 
    } 
} 
  
// Implementor for bridge pattern 
interface Workshop 
{ 
    abstract public void work(); 
} 
  
// Concrete implementation 1 for bridge pattern 
class Produce implements Workshop { 
    @Override
    public void work() 
    { 
        System.out.print("Produced"); 
    } 
} 
  
// Concrete implementation 2 for bridge pattern 
class Assemble implements Workshop { 
    @Override
    public void work() 
    { 
        System.out.print(" And"); 
        System.out.println(" Assembled."); 
    } 
} 
  
// Demonstration of bridge design pattern 
class BridgeDemo { 
    public static void main(String[] args) 
    { 
        Vehicle vehicle1 = new Car(new Produce(), new Assemble()); 
        vehicle1.manufacture(); 
        Vehicle vehicle2 = new Bike(new Produce(), new Assemble()); 
        vehicle2.manufacture(); 
    } 
} 
