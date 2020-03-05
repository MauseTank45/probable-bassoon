import java.io.File;
import java.io.FileWriter;

public class Main {
  public static void main(String[] args) {
  SlidingWindow slidingWindow1 = new SlidingWindow();
/*
    slidingWindow1.indexLAB = 17;
    System.out.println(slidingWindow1.searchBuffer);
    System.out.println(slidingWindow1.lookAheadBuffer);
    System.out.println(slidingWindow1.indexLAB);
    System.out.println(slidingWindow1.insideSearchBuffer(6));
  */
    OutputTuple OT = new OutputTuple();
    OT.length = 4;
    OT.offset = 5;
    OT.symbol = 's';
    System.out.println(OT.toOutputString());
  }
}

class Compression{
  SlidingWindow slidingObject;
  OutputTuple outputTupleObject;
  File inFile;
  FileWriter outFile;
  String inLine;
}

class SlidingWindow {
  final int searchBuffer;
  final int lookAheadBuffer;
  int indexLAB;

  public SlidingWindow(){
    searchBuffer = 10;
    lookAheadBuffer = 8;
    indexLAB = 0;
  }

  public SlidingWindow(int searchBuffer, int lookAheadBuffer){
    if (searchBuffer <= 0 && lookAheadBuffer <= 0) {
      throw new IllegalArgumentException("searchBuffer or lookAheadBuffer must be bigger than 0!");
    }
    else {
      this.searchBuffer = searchBuffer;
      this.lookAheadBuffer = lookAheadBuffer;
      indexLAB = 0;
    }
  }

  public boolean insideSearchBuffer(int index){
    return index >= 0 && index >= indexLAB - searchBuffer && index < indexLAB;
  }
}

class OutputTuple{
  int offset;
  int length;
  char symbol;

  public String toOutputString(){
    String S1 = "";
    return S1.concat(offset + "," + length + "," + symbol);
  }
}























/*class aircraft {
  int passengers;
  int cruiseSpeed;
  double fuelCapacity;
  double fuelBurnRate;

  void Endurance(){
    double endurance;

    endurance = fuelCapacity / fuelBurnRate;
    System.out.println("Endurance is "+ endurance + " hours");
  }
}*/