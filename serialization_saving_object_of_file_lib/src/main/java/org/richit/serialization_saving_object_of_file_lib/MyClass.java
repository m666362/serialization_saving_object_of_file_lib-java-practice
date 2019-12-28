package org.richit.serialization_saving_object_of_file_lib;

public class MyClass {
    static String dot = "----------------";

    private static void headingProgram(String heading) {
        System.out.println();
        System.out.println(dot+heading+dot);
        System.out.println();
    }

    public static void main(String[] args) {
        headingProgram("Start Programme");



        headingProgram("End Programme");
    }
}
