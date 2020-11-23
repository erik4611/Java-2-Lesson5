package ru.geekbrains.Java2_Lesson5;

public class Main1 {
    public static void main(String[] args) {


        mOne();
        mTwo();


    }

    public static void mOne() {                     // Метод №1
        final int size = 10000000;
//        final int h = size / 2;
        float[] arr = new float[size];

        long a = System.currentTimeMillis();
        System.out.println(a);
        for (int i = 0; i < size; i++) {
            arr[i] = 0;
        }
        System.out.println(System.currentTimeMillis() - a);

        long c = System.currentTimeMillis();
        System.out.println(a);
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
        System.out.println(System.currentTimeMillis() - c);
    }

    public static void mTwo () {                    // Метод №2
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();
        System.out.println(a);
        for (int i = 0; i < size; i++) {
            arr[i] = 0;
        }
        System.out.println(System.currentTimeMillis() - a);

        long c = System.currentTimeMillis();
        System.out.println(a);
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
        System.out.println(System.currentTimeMillis() - c);

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);


        var t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
            }
        });
        var t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
            }
        });
        long d = System.currentTimeMillis();
        System.out.println(d);
        t1.start();
        t2.start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - d);

    }

}


