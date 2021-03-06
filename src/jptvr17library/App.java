/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr17library;

import entity.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import providers.BookProvider;

/**
 *
 * @author Melnikov
 */
public class App {
    private List<Book> listBooks = new ArrayList<>();
    private StoregeInFile storegeInFile;
    public App() {
       storegeInFile = new StoregeInFile();
       listBooks = storegeInFile.loadFromFile();
    }
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Наша библиотека ----");
        String repeat = "r";
        int operation;
        do{
            System.out.println("Выберите действие:");
            System.out.println("1. Создать книгу");
            System.out.println("2. Создать читателя");
            System.out.println("3. Выдать книгу читателю");
            System.out.println("4. Читатель возвращает книгу");
            System.out.println("5. Вывести список книг");
            operation = scanner.nextInt();
            scanner.nextLine();
            switch (operation) {
                case 1:
                    BookProvider bookProvider = new BookProvider();
                    listBooks.add(bookProvider.createBook());
                    storegeInFile.saveBooks(listBooks);
                    for(int i=0; i < listBooks.size();i++){
                       System.out.println(
                            "Список книг: " 
                            + listBooks.get(i).getName()
                        ); 
                    }
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.println("Список книг: ");
                    for(int i=0;i<listBooks.size();i++){
                        System.out.println(listBooks.get(i));
                    }
                    break;    
                default:
                    System.out.println("Такое действие неподдерживается");
                    continue;
            }
            System.out.println("Для продолжения программы");
            System.out.println("введите \"r\"");
            System.out.println("Для окончания \"q\"");
            repeat = scanner.nextLine();
        }while("r".equals(repeat));
        System.out.println("Программа закрывается");
    }
    
}
