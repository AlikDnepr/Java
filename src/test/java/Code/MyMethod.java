package Code;

public class MyMethod {
        static int step = 1;
        static void myMethod() {

             //начальное значение

            //step++;

            System.out.println("I just got executed!" + step);
            step++;
        }



        public static void main(String[] args) {

            myMethod();

            myMethod();

            myMethod();

        }

}
//step - 1
//step - 2
//step - 3
