/*
МНЕ нравится курс JavaRush
*/

public class Task2071 {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    }

    public static String getFormattedString() {
        return "%3$S %4$s %2$s %1$s";
    }
}
