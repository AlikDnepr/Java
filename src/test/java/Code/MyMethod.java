package Code;

public class MyMethod {
        static int step = 1; //initial value!
        static void myMethod() {

            System.out.println("I just got executed!" + step);
            step++;
        }



        public static void main(String[] args) {
            myMethod();
            myMethod();
            myMethod();

        }

}
//Response:
//step - 1
//step - 2
//step - 3
