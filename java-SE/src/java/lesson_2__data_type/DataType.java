package lesson_2__data_type;

public class DataType {

    /*
      Примитивные типы ------------------------------------------------------------------------------------------
   */
    byte aByte = 0;                     // 8 bit  | 1 byte (+-2^7 = +-256) : -128 - +127
    short aShort = 1234;                // 16 bit | 2 byte (2^15 = +-65000) : -32000 - +32000
    int anInt = 1234567890;             // 32 bit | 4 byte (2^31 = 4_000_000_000) : -2_000_000_000 - +2_000_000_000
    long aLong = 1234;                  // 64 bit | 8 byte (2^63)

    float  aFloat = 1.1234567F;          // 32 bit | 4 byte
    double aDouble = 1.123456789012345; // 64 bit | 8 byte

    boolean aBoolean = false;           // false | true

    char aChar = 'a';                   // 1 symbol


    public static void main(String[] args) {

        int myInt;
        myInt = 557;
        System.out.println(myInt);

    }
}
