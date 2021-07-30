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

    public void printError() {
        System.out.println("Activity: " + active);
        System.out.println("Error status:" + status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error firsError = new Error();
        Error secondError = new Error(false, 1, "Something wrong");
        Error thirdError = new Error(true, 2, "Something wrong again");
        firsError.printError();
        System.out.println();
        secondError.printError();
        System.out.println();
        thirdError.printError();
    }
}
