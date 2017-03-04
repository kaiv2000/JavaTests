package OOP;


public class SingletonLazy { // екземпляр створить ся лише при явному виклику методу

    private static SingletonLazy instance;

    private SingletonLazy(){

    }

    public static synchronized SingletonLazy getInstance(){ // має бути синхронізованим для використання багатьма потоками. створює екземпляр, якщо він ще не був створений
        if (instance == null){
            instance = new SingletonLazy();
        }
    return instance;
    }


}
