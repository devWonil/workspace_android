package com.example.myretrofit3;

// 싱글톤 패턴

public class MyPrinter {

    private static MyPrinter myPrinter;

    private MyPrinter() {}

    public static MyPrinter getInstance() {
        if (myPrinter == null) {
            myPrinter = new MyPrinter();
        }
        return myPrinter;
    }

    // 테스트 코드 작성
    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        // 레퍼런스 주소비교 (같다면 같은 객체)
        MyPrinter myPrinterA = aClazz.myPrinter;
        MyPrinter myPrinterB = bClazz.myPrinter;

        System.out.println(myPrinterA.equals(myPrinterB));
    }
}

class AClazz {
    public MyPrinter myPrinter;

    public AClazz() {
        myPrinter = MyPrinter.getInstance();
    }
}

class BClazz {
    public MyPrinter myPrinter;

    public BClazz() {
        myPrinter = MyPrinter.getInstance();
    }
}
