package com.michaelmuratov.warehouse.Engine.Util.Data;
public class Stack<E>{

    private E[] array;
    private int counter = 0;
    private int size;

    public Stack(int size){
        this.size = size;
        array = (E[]) new Object[size];
    }

    public void push(E newint){

        if(counter==size) {
            extendArray();
        }

        array[counter] = newint;
        counter++;
    }

    public E pop(){
        if(size >= counter*2) {
            shrinkArray();
        }
        counter--;
        return array[counter];
    }

    private void extendArray(){
        E[] newarray = (E[]) new Object[2*size];
        System.arraycopy(array, 0, newarray, 0, counter);
        size = size*2;
        array = newarray;
    }

    private void shrinkArray() {
        E[] newarray = (E[]) new Object[counter];
        System.arraycopy(array, 0, newarray, 0, counter - 1);
        size = counter;
        array = newarray;
    }

    public E[] getArray(){
        return array;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for(int i =0; i<counter; i++){
            string.append(" ").append(array[i]);
        }
        return string.toString();
    }
}
