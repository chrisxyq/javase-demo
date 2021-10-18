package proxyDemo.resource;

public class Cat implements Animal {

    @Override
    public void call() {
        System.out.println("喵喵喵 ~");
    }
    public void hobby(){
        System.out.println("fish ~");
    }
}
