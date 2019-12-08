package com._520.leetcode.test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookSystemTest {
    // 存放图书
    private static List<Book> books = new ArrayList<>();
    // 存放购买的图书
    private static List<Book> bookCart = new ArrayList<>();
    // 上架图书
    private static void addBook(Book book){
        for (Book b:books
             ) {
            // 图书已经存在
            if (b.getName().equals(book.getName())){
                // 增加库存
                b.setStock(b.getStock() + book.getStock());
                return;
            }
        }
        books.add(book);
    }
    // 下架图书
    private static void deleteBook(String name){
        for (Book b:books
             ) {
            // 如果名称相同就删除
            if (b.getName().equals(name)){
                books.remove(b);
                //
                return;
            }
        }
        System.out.println("你好，你要删除的图书不存在！");
    }

    // 借书
    private static void borrow(String name) {
        for (Book b:books
        ) {
            if (b.getName().equals(name) && b.getStock() != 0){
                // 库存减一
                b.setStock(b.getStock() - 1);
                System.out.println("借书成功！");
                return;
            }
        }
        System.out.println("没有你要借的书！");
    }

    // 还书
    private static void returnBook(String name){
        for (Book b:books
        ) {
            if (b.getName().equals(name)){
                // 库存减一
                b.setStock(b.getStock() + 1);
                System.out.println("还书成功！");
                return;
            }
        }
        System.out.println("你没有借支这本书！");
    }
    // 查看所有图书
    private static void list(){
        for (Book b:books
             ) {
            System.out.println(b);
        }
    }

    // 买书
    private static void buyBook(String name){
        for (Book b:books
        ) {
            if (b.getStock() == 0){
                System.out.println("库存不足，无法购买！");
                return;
            }
            if (b.getName().equals(name)){
                bookCart.add(b);
                // 库存减一
                b.setStock(b.getStock() - 1);
                System.out.println("购买成功！");
                return;
            }
        }
        System.out.println("你输入的图书名称有误，购买失败！");
    }

    // 查看订单
    private static void bookCartList(){
        if (bookCart.size() == 0){
            System.out.println("订单为空");
            return;
        }
        for (Book b:bookCart
             ) {
            System.out.println(b);
        }
    }
    public static void main(String[] args) {
        ArrayList normalUser = new ArrayList<>();
        ArrayList adminUser = new ArrayList<>();

        //录入普通用户信息
        normalUser.add(new User("z", "1"));
        normalUser.add(new User("lisi", "ls123456"));
        normalUser.add(new User("wangwu", "ww123456"));
        normalUser.add(new User("zhangsi", "zs123456"));
        normalUser.add(new User("liwu", "lw123456"));
        normalUser.add(new User("wangliu", "wl123456"));


        //录入管理员信息
        adminUser.add(new User("t", "1"));

        boolean bool = true;
        while (bool){
            //登陆
            System.out.println("请选择身份  管理员：1   用户：2    退出：0");
            Scanner scan = new Scanner(System.in);
            int identified = scan.nextInt();

            //管理员身份的操作
            if(identified == 1){
                System.out.println("请输入管理员用户名和密码：");
                String id = scan.next();
                String psd = scan.next();

                for(Object obj: adminUser){
                    if(obj instanceof User){
                        User user = (User)obj;
                        if(user.getId().equals(id) && user.getPassword().equals(psd)){
                            System.out.println("登陆成功！");
                            //实现上架图书和下架图书的操作
                            boolean flag = true;
                            while (flag){
                                System.out.println("请继续操作  上架图书：1  下架图书：2  退出：0 ");
                                int key = scan.nextInt();

                                switch (key){
                                    case 1:
                                        System.out.println("请输入图书的名称：");
                                        String name = scan.next();
                                        System.out.println("请输入图书的个数：");
                                        int stock = scan.nextInt();
                                        System.out.println("请输入图书的价格：");
                                        int price = scan.nextInt();
                                        addBook(new Book(name,stock,price));
                                        list();
                                        break;
                                    case 2:
                                        System.out.println("请输入下架图书的名称：");
                                        name = scan.next();
                                        deleteBook(name);
                                        list();
                                        break;
                                    case 0:
                                        flag = false;
                                        break;

                                    default:
                                        break;
                                }
                            }

                        }else{
                            System.out.println(id + " "+psd);
                            System.out.println("用户名或密码错误，请重新输入");
                            //实现用户只能输入3次，3次之后如果不正确直接退出这个系统

                        }
                    }
                }
            }else if(identified == 2){
                System.out.println(identified);
                System.out.println("请输入用户名和密码：");
                String id = scan.next();
                String psd = scan.next();

                for(Object obj: normalUser){
                    if(obj instanceof  User){
                        User user = (User)obj;
                        System.out.println(user);
                        if(user.getId().equals(id) && user.getPassword().equals(psd)) {
                            System.out.println("登陆成功！");
                            //实现查询图书、借书、还书、买书、查询订单这些功能

                            boolean flag = true;
                            while (flag){
                                System.out.println("1、查询图书   2、借书   3、还书   4、买书    5、查询订单     0、退出");
                                int key = scan.nextInt();
                                switch (key){
                                    case 1:
                                        list();
                                        break;
                                    case 2:
                                        System.out.println("请输入图书名称：");
                                        String name = scan.next();
                                        borrow(name);
                                        break;
                                    case 3:
                                        System.out.println("请输入书名：");
                                        name = scan.next();
                                        returnBook(name);
                                        break;
                                    case 4:
                                        System.out.println("请输入要买的书名：");
                                        name = scan.next();
                                        buyBook(name);
                                    case 5:
                                        bookCartList();
                                        break;
                                    case 0:
                                        flag = false;
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }else{
                            System.out.println("用户名或密码错误，请重新输入");
                            //实现用户只能输入3次，3次之后如果不正确直接退出这个系统
                        }
                    }
                }
            }else{
                bool = false;
                System.out.println("退出系统");
            }
        }

    }


}
