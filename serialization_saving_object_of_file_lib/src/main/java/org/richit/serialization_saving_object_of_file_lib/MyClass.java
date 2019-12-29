package org.richit.serialization_saving_object_of_file_lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
        arrayWriteObject();
        arrayReadObject();
        newMethodArrayObjectWrite();
        newMethodArrayObjectRead();

        headingProgram("End Programme");
    }

    private static void newMethodArrayObjectRead() {
        headingProgram( "newMethodArrayObjectRead" );
        try (FileInputStream fileInputStream = new FileInputStream( "Array.txt" )){
            ObjectInputStream objectInputStream = new ObjectInputStream( fileInputStream );
            ArrayList<Person> peoples = (ArrayList<Person>) objectInputStream.readObject();
            for (Person man:peoples){
                System.out.println(man);
            }
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    private static void newMethodArrayObjectWrite() {
        headingProgram( "newMethodArrayObjectWrite" );
        try (FileOutputStream fileOutputStream = new FileOutputStream( "Array.txt" )){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );
            ArrayList<Person> richs = new ArrayList<>(  );
            richs.add( new Person( "jack", 2 ) );
            richs.add( new Person( "jhon", 3 ) );
            richs.add( new Person( "tesla", 4 ) );
            richs.add( new Person( "alpha", 5 ) );
            objectOutputStream.writeObject( richs);
            System.out.println("Writing Array Object");
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void arrayReadObject() {
        headingProgram( "arrayReadObject" );
        try (FileInputStream fileInputStream = new FileInputStream( "Text.txt" )){
            ObjectInputStream objectInputStream = new ObjectInputStream( fileInputStream );
            Person[] peoples = (Person[]) objectInputStream.readObject();
            for (Person man:peoples){
                System.out.println(man);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void arrayWriteObject() {
        headingProgram( "arrayWriteObject" );
        Person[] peoples = {new Person( "Jack", 1 ), new Person( "Jhon", 5 ), new Person( "Simens", 3 )};
        try (FileOutputStream fileOutputStream = new FileOutputStream( "Text.txt" )){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );
            objectOutputStream.writeObject( peoples );
            System.out.println("Writing Object");
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            System.out.println("Writing Object");
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
