package lesson_5;

import java.util.Arrays;

public class main {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public static void main(String[] args) {
        methodOne(createArray());
        methodTwo(createArray());
    }

    private static float[] createArray(){
        float[] arr = new float[size];
        for(int i=0; i<arr.length; i++){
            arr[i]=1;
        }
        return arr;
    }


    private static void methodOne(float[]arr){
        System.out.println(Arrays.toString(arr));
        long a = System.currentTimeMillis();
        for(int i=0; i<arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("Время 1");
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void methodTwo(float[] arr){
        System.out.println(Arrays.toString(arr));
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long b = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        Thread calc1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<a1.length; i++){
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5)
                                          * Math.cos(0.2f + i / 5)
                                          * Math.cos(0.4f + i / 2));
                }
            }
        });
        calc1.start();

        Thread calc2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<a2.length; i++){
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + (i+h) / 5)
                                           * Math.cos(0.2f + (i+h) / 5)
                                           * Math.cos(0.4f + (i+h) / 2));
                }
            }
        });
        calc2.start();

        try{
            calc1.join();
            calc2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(Arrays.toString(arr));
        System.out.println("Время 2");
        System.out.println(System.currentTimeMillis() - b);
    }
}
