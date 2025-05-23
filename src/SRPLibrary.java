import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Book{
    private String Bookname;
    private String Authorname;
    private int Edition;
    private boolean isAvailable;
    Book(String Bookname,String Authorname,int Edition){
        this.Bookname=Bookname;
        this.Authorname=Authorname;
        this.Edition=Edition;
        this.isAvailable=true;
    }

    Boolean checkavailability(){
        return isAvailable;
    }
    String getBookname(){
        return Bookname;
    }
    void makeBorrow(){
        isAvailable=false;
    }
    void makeReturn(){
        isAvailable=true;
    }
}
class User{
    private String name;
    private int memberid;
    User(String name,int memberid){
        this.name=name;
        this.memberid=memberid;
    }
    String getUsernmae(){
        return name;
    }
}
class UserRegister{
    List <User>userlist=new ArrayList<>();
    void adduser(User user){
        userlist.add(user);
    }
    boolean ValidateUser(String name){
            for(User u:userlist){
                if(u.getUsernmae().equals(name)){
                    return true;
                }
            }
            return false;
    }
}
class Borrowmanager{
    private HashMap <String,Integer>borrow= new HashMap<>();
    boolean addborrow(String name){
        if(borrow.containsKey(name)&&borrow.get(name)<3){
            borrow.put(name, borrow.getOrDefault(name, 0)+1);
            System.out.println(borrow.get(name)+"/3 is borrowed");
            return true;
        }
        else if(borrow.containsKey(name)&&borrow.get(name)==3){
            System.out.println("Limit exceeds");
                return false;
        }
        else{
            borrow.put(name, 1);
            System.out.println(borrow.get(name)+"/3 is borrowed");
            return true;
        }
    }
    void removeborrow(String name){
        if(borrow.containsKey(name)&&borrow.get(name)>=1){
            borrow.put(name, borrow.getOrDefault(name, 0)-1);
            System.out.println("Limit updated: "+borrow.get(name)+"/3");
            if(borrow.get(name)==0) borrow.remove(name);
        }
        else{
            System.out.println("No Booked is borrowed by the Customer. ");
        }
    }
}
class Librarian{
    List <Book>booklist=new ArrayList<>();
    void addbook(Book book){
        booklist.add(book);
    }
    List getbooklist(){
        return booklist;
    }
}
class LibrarryManagement{
    private Librarian lib;
    private UserRegister ur;
    private Borrowmanager b;
    LibrarryManagement(Librarian lib,UserRegister ur,Borrowmanager b){
        this.lib=lib;
        this.ur=ur;
        this.b=b;
    }
    void borrowbook(String username,String name){
     List<Book>books=lib.getbooklist();
        if(ur.ValidateUser(username)){
        for(Book book:books){
            if(book.getBookname().equals(name)&&book.checkavailability()){
                if(b.addborrow(name)){
                book.makeBorrow();
                System.out.println("The Book named: "+name+" is borrowed by "+username+" Successfully");
                return;
                }
                else{
                    return;
                }
            }
        }
    }
    else{
        System.out.println("Enter valid user name(Invalid user) "+ username);
    }
    }

    void returnBook(String username,String bookname){
        List<Book>books=lib.getbooklist();
        if(ur.ValidateUser(username)){
        for(Book book:books){
            if(book.getBookname().equals(bookname)&& ! book.checkavailability()){
                b.removeborrow(bookname);
                book.makeReturn();
                return;
                
            }
        }
        System.out.println("No Book Found.Please check for the correct book name.");
        
    }
}

}

public class SRPLibrary {
    public static void main(String[] args) {
        Librarian lin = new Librarian();
        UserRegister us= new UserRegister();
        Borrowmanager b = new Borrowmanager();
        LibrarryManagement lib=new LibrarryManagement(lin,us,b);
        lin.addbook(new Book("PonniyenSelvam", "Kalki", 1999));
        lin.addbook(new Book("HarryPotter", "Rolling", 2005));
        lin.addbook(new Book("PirateOfTheCarrabiean", "Elliot", 2000));
        lin.addbook(new Book("NCERT_Science", "NCERT", 2021));

        us.adduser(new User("Kalaiselvam",46));
        us.adduser(new User("Kamalesh",47));
        us.adduser(new User("JalumDhinesh",42));
        us.adduser(new User("Jegatha",45));

        lib.borrowbook("Kalaiselvam", "HarryPotter");
        lib.returnBook("Kalaiselvam", "HarryPotter");
        lib.returnBook("Kalaiselvam", "HarryPottr");
        

    }
    
}
