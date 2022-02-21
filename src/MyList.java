public class MyList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY=10;
    Object elements[];

    public MyList() {
        size=DEFAULT_CAPACITY;
        elements=new Object[size];
    }

    public MyList(int size) {
        this.size = size;
        elements=new Object[size];
    }
    Object[] add(int index, E element){
        if(index<0){
            return elements;
        }
        int newSize=size+1;
        Object[] tempList=new Object[newSize];
        if(size<=index){
            tempList[size]=element;
        }
        else {
            for (int i = 0; i < index; i++) {
                tempList[i]=elements[i];
            }
            tempList[index]=element;
            for (int i = index+1; i <size ; i++) {
                tempList[i]=elements[i-1];
            }
        }
        size++;
        return tempList;
    }
    int size(){
        return size;
    }
    Object remove(int index){
        if(index<0){
            return null;
        }else {
            if (index > size) index = size-1;
            Object temp[]=new Object[size-1];
            for (int i = 0; i < index; i++) {
                temp[i]=elements[i];
            }
            for (int i = index; i <size ; i++) {
                temp[i]=elements[i+1];
            }
            Object view = elements[index];
            elements=temp;
            return view;
        }

    }
    Object[] cloneElement(){
        Object[] tempList = new Object[size];
        for (int i = 0; i < size; i++) {
            tempList[i]=elements[i];
        }
        return tempList;
    }
    boolean contains(E o){
        for (int i = 0; i < size; i++) {
            if(o==elements[i]){
                return true;
            }
        }
        return false;
    }
    int indexOf(E o){
        for (int i = 0; i < size; i++) {
            if(o==elements[i]){
                return i;
            }
        }
        return -1;
    }
    void ensureCapacity(){
        size+=DEFAULT_CAPACITY;
    }
    Object get(int index){
        return elements[index];
    }
    void clear(){
        size=0;
        elements = new Object[0];
    }

}
