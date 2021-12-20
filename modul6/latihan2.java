public class latihan2 {

    public static void main (String args []){

        int score = 800;
        int income = 50000;
        boolean authorized = true;

        /* sebelum di refactoring
        if (score > 700) {
            accept();
        } else if ((income >= 40000) && (income <= 100000) && authorized && (score > 500)) {
            accept();
        } else if (income > 100000) {
            accept();
        } else {
            reject();
        }
        */

        // setelah di refactoring
        if ((score <= 700) && (income < 40000) || (income > 100000) || !authorized || (score <= 500) &&(income <= 100000)) {
            reject();
        } else {
            accept();
        }

    }

    public static void reject(){
        System.out.println("Di Tolak.");
    }

    public static void accept(){
        System.out.println("Di Terima");
    }
}