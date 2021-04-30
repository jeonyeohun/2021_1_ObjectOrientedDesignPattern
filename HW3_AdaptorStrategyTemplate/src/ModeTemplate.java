public abstract class ModeTemplate {
     void runVehicle(){
          convertMode();
          startEngine();
          manageElectricity();
          manageFuel();
          generateCharge();
          generateBrakeEnergyCharge();
          checkSpeed();
     }

     abstract void convertMode();
     abstract void startEngine();
     abstract void checkSpeed();
     abstract void manageElectricity();
     abstract void manageFuel();

     public void generateCharge() {
          System.out.println("Main generator charges battery.");
     }
     public void generateBrakeEnergyCharge() {
          System.out.println("Regenerative brake energy charges battery.");
     }

     public final String toString(CarMode carMode){
          switch (carMode){
               case FUELMODE:
                    return "fuel car mode";
               case HYBRIDMODE:
                    return "hybrid car mode";
               case ELECTRICMODE:
                    return "electric car mode";
          }
          return null;
     }
}