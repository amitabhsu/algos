package com.r1.testjava8;

public class GenericTest {
	 
    public static void main(String args[]) {
       
        //string wrapper
        Wrapper<String> stringWrapper = new Wrapper<String>();
        stringWrapper.setItem("Test");
        System.out.println(stringWrapper.getItem());
       
        //compilation error, type checking at compile time
        //stringWrapper.setItem(new StringBuffer(""));
     
        Wrapper<Integer> integerWrapper = new Wrapper<Integer>();
        integerWrapper.setItem(123);
       
        //compilation error, type safety checking
        //integerWrapper.setItem("123");
        System.out.println(integerWrapper.getItem());
     
     
        // Now let's see how to write generic wrapper without using
        // JDK1.5 generic and what problem it poses
     
        OldWrapper oldStringWrapper = new OldWrapper();
     
        //no compilation error i.e. no type checking at compile time
        oldStringWrapper.setItem(123);

        //will throw ClassCastException at runtime  
        ((String)oldStringWrapper.getItem()).toUpperCase();
    }
}

/*
 * wrapper can wrap any item
 * Generic parameterized form of Wrapper, offers compile time type checking
 */
class Wrapper<T> {
    private T item;
 
    public T getItem(){
        return item;
    }
 
    public void setItem(T item){
        this.item = item;
    }
}

/*
 * Object form of Wrapper fragile and error prone
 */
class OldWrapper{
    private Object item;
 
    public Object getItem(){
        return item;
    }
 
    public void setItem(Object item){
        this.item = item;
    }
}

//Read more: http://javarevisited.blogspot.com/2012/08/how-to-write-parametrized-class-method-Generic-example.html#ixzz4C9HdZZB2

