package StartAtGoogle.week2.CommonMethods;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Name name = new Name(Name.Prefix.MR,"Dvir","Shaul");
        Name name2 = name.clone();
        System.out.println("equal 2 name with clone: "+ name.equals(name2));

        System.out.println("check both hashcode after clone: "+name.hashCode() + name2.hashCode());


        System.out.println("print name"+name);
        PhoneNumber pn = new PhoneNumber(972, 545381648);
        System.out.println("print phone number "+pn);
        Contact c = new Contact(name,pn);
        System.out.println(c);
        ArrayList<Contact> arrContact = new ArrayList<>();
        arrContact.add(c);

        PhoneBook pb = new PhoneBook(arrContact,"dapi zahav");
        System.out.println("1 contact in book: "+pb);

        Name name1 = new Name(Name.Prefix.MR,"David","MA");
        PhoneNumber pn1 = new PhoneNumber(972, 545381648);
        Contact c1 = new Contact(name1,pn1);
        pb.addToPB(c1);
        System.out.println("2 contact in book: "+pb);
        System.out.println("check both hashcode after clone: "+c.hashCode() + c1.hashCode());

        Name name3 = new Name(Name.Prefix.MR,"Dvir","Shaul");
        PhoneNumber pn2 = new PhoneNumber(982, 545381648);
        Contact c2 = new Contact(name3,pn2);
        pb.addToPB(c2);
        System.out.println("3 contact in book: "+pb);



    }
}
