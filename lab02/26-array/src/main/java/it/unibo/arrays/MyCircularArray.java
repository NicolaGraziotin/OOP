package it.unibo.arrays;

class MyCircularArray {

    int[] array;
    int index;

    MyCircularArray() {
        this(10);
    }

    MyCircularArray(int size) {
        this.array = new int[size];
        this.index = 0;
    }

    void add(final int elem) {
        if (index < array.length) {
            array[index++] = elem;
        } else {
            index = 0;
            array[index++] = elem;
        }
    }

    void reset() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = 0;
        }
        this.index = 0;
    }

    void printArray() {
        System.out.print("[");
        for (int i = 0; i < this.array.length - 1; i++) {
            System.out.print(this.array[i] + ",");
        }
        System.out.print(this.array[this.array.length - 1] + "]");
    }

    public static void main(final String[] args) {

        // 1) Creare un array circolare di dieci elementi

        // 2) Aggiungere gli elementi da 1 a 10 e stampare il contenuto
        // dell'array circolare

        // 3) Aggiungere gli elementi da 11 a 15 e stampare il contenuto
        // dell'array circolare

        // 4) Invocare il metodo reset

        // 5) Stampare il contenuto dell'array circolare

        // 6) Aggiungere altri elementi a piacere e stampare il contenuto
        // dell'array circolare

        MyCircularArray array = new MyCircularArray();

        for (int i = 0; i < 10; i++) {
            array.add(i+1);
        }
        array.printArray();

        for (int i = 10; i < 15; i++) {
            array.add(i+1);
        }
        array.printArray();

        array.reset();

        array.printArray();
    }
}
