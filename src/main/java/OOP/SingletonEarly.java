package OOP;

public class SingletonEarly { // загрузиться і створиться екземпляр при першому звернення до будь якого поля класу

    public static final SingletonEarly instance = new SingletonEarly(); //створення єдиного об'єкту класу

    private SingletonEarly(){ //об'явлення приватного конструктора для заборони створення екземплярів класу
    }
}
