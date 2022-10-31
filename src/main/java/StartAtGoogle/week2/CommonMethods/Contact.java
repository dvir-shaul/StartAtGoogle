package StartAtGoogle.week2.CommonMethods;

import java.util.ArrayList;
import java.util.Objects;


/**
 * class Contact
 */
public class Contact implements Cloneable, Comparable<Contact>{

    private Name name;
    private PhoneNumber phoneNumber;

    public Contact(Name name1,PhoneNumber pn){
        this.name = name1;
        this.phoneNumber=pn;
    }
    

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                 name.toString()+
                 phoneNumber.toString()+
                '}';
    }

    @Override
    public boolean equals(Object  o) {
        if (this == o)
            return true;
        if (!(o instanceof Contact))
            return false;
        Contact that = (Contact) o;
        return name.equals(that.name) &&
                phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,phoneNumber);
    }

    @Override
    protected Contact clone() throws CloneNotSupportedException {
        try{
            Contact c = (Contact) super.clone();
            c.name = this.name;
            c.phoneNumber = new PhoneNumber(this.phoneNumber.getAreaCode(),this.phoneNumber.getNumber());
            return c;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(Contact o) {
        if(this.name.compareTo(o.name)<0)
            return -1;
        if(this.name.compareTo(o.name)>0)
            return 1;
        if (phoneNumber.compareTo(o.phoneNumber)<0)
            return -1;
        if (phoneNumber.compareTo(o.phoneNumber)>0)
            return 1;
        return 0;
    }

}


/**
 * class PhoneNumber
 */
class PhoneNumber implements Cloneable, Comparable<PhoneNumber>{
    private int areaCode;
    private int number;

    public PhoneNumber(int a,int b){
        this.areaCode=a;
        this.number=b;
    }
    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object  o) {
        if (this == o)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode && number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "areaCode=" + areaCode +
                ", number=" + number +
                '}';
    }

    @Override
    protected PhoneNumber clone() throws CloneNotSupportedException {
        try{
            PhoneNumber pn = (PhoneNumber) super.clone();
            pn.areaCode = this.areaCode;
            pn.number = this.number;
            return pn;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int compareTo(PhoneNumber o) {
        if(this.areaCode < o.areaCode)
            return -1;
        if(this.areaCode > o.areaCode)
            return 1;
        if (this.number < o.number)
            return -1;
        if (this.number > o.number)
            return 1;
        return 0;
    }
}



/**
 * class Name
 */
class Name implements Cloneable, Comparable<Name>{
    private Prefix prefix;

    Name(Prefix prefix, String fName, String lName) {
        this.prefix = prefix;
        this.fName = fName;
        this.lName = lName;
    }


    enum Prefix {MR,MRS};
    private String fName;
    private String lName;


    @Override
    public boolean equals(Object  o) {
        if (this == o)
            return true;
        if (!(o instanceof Name))
            return false;
        Name that = (Name) o;
        return prefix == that.prefix &&
                fName.equals(that.fName) &&
                lName.equals(that.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, fName,lName);
    }

    @Override
    public String toString() {
        return "{" +
                "Prefix=" + prefix +
                ", fName=" + fName +
                ", lName=" + lName +
                '}';
    }

    @Override
    protected Name clone() throws CloneNotSupportedException {
        try{
            Name pn = (Name) super.clone();
            pn.prefix = this.prefix;
            pn.fName = this.fName;
            pn.lName = this.lName;
            return pn;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int compareTo(Name o) {
        if(this.prefix.compareTo(o.prefix) < 0)
            return -1;
        if(this.prefix.compareTo(o.prefix) > 0)
            return 1;
        if(this.fName.compareTo(o.fName) < 0)
            return -1;
        if(this.fName.compareTo(o.fName) > 0)
            return 1;
        if(this.lName.compareTo(o.lName) < 0)
            return -1;
        if(this.lName.compareTo(o.lName) > 0)
            return 1;
        return 0;
    }

}

/**
 * class PhoneBook
 */
class PhoneBook{
    private ArrayList<Contact> phoneBook;
    private String name;

    public PhoneBook(ArrayList<Contact> phoneBook, String name) {
        this.phoneBook = phoneBook;
        this.name = name;
    }

    public void addToPB(Contact c){
        this.phoneBook.add(c);
        this.phoneBook.sort(Contact::compareTo);
    }
    public ArrayList<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(ArrayList<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append("Print PhoneBook contacts\n");
        for (Contact c: phoneBook) {
            ans.append(c.toString()).append("\n");
        }
        return ans.toString();
    }
}
