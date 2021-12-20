public class Person {

    public String name;
    
    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }


    public static void main (String args []){
        Person person = new Person();
        person.setName("Bob Smith");
        System.out.println(person.getName());
    }
}