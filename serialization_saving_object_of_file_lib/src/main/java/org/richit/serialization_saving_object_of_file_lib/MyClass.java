package org.richit.serialization_saving_object_of_file_lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyClass {
    static String dot = "----------------";

    private static void headingProgram(String heading) {
        System.out.println();
        System.out.println(dot+heading+dot);
        System.out.println();
    }

    public static void main(String[] args) {
        headingProgram("Start Programme");

        writeObject();
        fileOutputStream();
        fileInputStream();

        headingProgram("End Programme");
    }

    private static void fileInputStream() {
        headingProgram( "fileInputStream" );

        try (FileInputStream fileInputStream = new FileInputStream( "Test.txt" )){

            ObjectInputStream objectInputStream = new ObjectInputStream( fileInputStream );
            try {
                Person person1 = (Person) objectInputStream.readObject();
                Person person2 = (Person) objectInputStream.readObject();

                System.out.println(person1);
                System.out.println(person2);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileOutputStream() {
        headingProgram( "fileOutputStream" );

        Person mike = new Person( "Mike", 512 );
        Person jhon = new Person( "Jhon", 615 );
        try (FileOutputStream fileOutputStream = new FileOutputStream( "Test.txt" )){

            ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );
            objectOutputStream.writeObject(mike);
            objectOutputStream.writeObject( jhon );
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeObject() {

        headingProgram( "writeObject" );

        Person mike = new Person( "Mike", 512 );
        Person jhon = new Person( "Jhon", 615 );
        System.out.println(mike);
        System.out.println(jhon);
    }

}
