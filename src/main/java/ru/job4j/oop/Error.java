package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Статус блокировки: " + active);
        System.out.println("Номер ошибки: " + status);
        System.out.println("Причина ошибки: " + message);
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        errorDefault.printInfo();
        Error error404 = new Error(true, 404, " доступ ограничен\n");
        error404.printInfo();
        Error error000 = new Error(false, 000, " нажмите ctrl + F5 и очистите кэш\n");
        error000.printInfo();
        Error error2021 = new Error(true, 2021, " ты должен был начать программировать раньше\n");
        error2021.printInfo();
    }
}
