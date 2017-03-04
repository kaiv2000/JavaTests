package NetworkServlet;

public class PhraseMatic {

    public static String makePhrase(){

        String[] listOne = {"цілодобовий","найкращий","суперовий","динамічний"};
        String[] listSecond = {"центральний","розподілений","позиціонований","проникаючий"};
        String[] listThird = {"пункт","мережевик","програмний","потрал"};

        int oneLength = listOne.length;
        int secondLength = listSecond.length;
        int thirdLength = listThird.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * secondLength);
        int rand3 = (int) (Math.random() * thirdLength);

        String phrase = listOne[rand1] + " " + listSecond[rand2] + " " + listThird[rand3];

        return "Все, що нам потрібно - це " + phrase;

    }

}
