package org.example;

import java.io.File;
import java.util.Scanner;

public class ExampleFile {
    File file;

    public ExampleFile(String filename){
        this.file = new File(filename);
    }

    public boolean checkExecute(){
        //check file can execute
        return this.file.canExecute();
    }

    public boolean checkRead(){
        //check file can read
        return this.file.canRead();
    }

    public boolean checkWrite() {
        //check file can write
        return this.file.canWrite();
    }

    public void printPathFile(){
        System.out.println(this.file.getAbsolutePath());
    }

    public void printNameFile(){
        System.out.println(this.file.getName());
    }

    public void checkIsFolderOrFile() {
        if(this.file.isDirectory()){
            System.out.println("This is a folder");
        }else if(this.file.isFile()) {
            System.out.println("This is a file");
        }
    }
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void printListChildFiles() {
        if (this.file.isDirectory()) {
            System.out.println("Lists childen file / childen folder is: ");
            File [] arrayFiles = this.file.listFiles();
            for (File file : arrayFiles) {
                System.out.println(file.getAbsoluteFile());
            }
        }
    }

    public void printTreeFolder() {
        this.printDetailTreeFolder(this.file,1);
    }

    public void printDetailTreeFolder(File file, int level) {

        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.print("|_");
        System.out.println(file.getName());
        if (file.canRead() && file.isDirectory()){
            File [] arrChildFiles = file.listFiles();
            for(File fx: arrChildFiles){
                printDetailTreeFolder(fx, level+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        System.out.println("Enter file name: ");

        String filename = sc.nextLine();
        ExampleFile exampleFile = new ExampleFile(filename);

        do{
            System.out.println("MENU--------------------------------");
            System.out.println("1. Check can execute file.");
            System.out.println("2. Check can read file");
            System.out.println("3. Check can write file");
            System.out.println("4. Print path file");
            System.out.println("5. Print file name");
            System.out.println("6. Check file is folder or file");
            System.out.println("7. Print list folder");
            System.out.println("8. Print list folder");
            System.out.println("0. Exit program");

            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println(exampleFile.checkExecute());
                    break;
                case 2:
                    System.out.println(exampleFile.checkRead());
                    break;
                case 3:
                    System.out.println(exampleFile.checkWrite());
                    break;
                case 4:
                    exampleFile.printPathFile();
                    break;
                case 5:
                    exampleFile.printNameFile();
                    break;
                case 6:
                    exampleFile.checkIsFolderOrFile();
                    break;
                case 7:
                    exampleFile.printListChildFiles();
                    break;
                case 8:
                    exampleFile.printTreeFolder();
                    break;
                default:
                    break;
            }
        }while(choose != 0);

    }
}
