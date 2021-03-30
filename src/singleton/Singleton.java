package singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton(){
        //생성자
    }

    //스레드의 문제
    /*
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }*/

    /*
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }*/
    
    //Holder에 의한 초기화
    public static class Holder{
        public static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance(){
        return Holder.INSTANCE;
    } 
}
