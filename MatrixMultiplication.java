import java.util.*;

public class MatrixMultiplication{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row and columns of Matrix A: ");
        int a_row = sc.nextInt();
        int a_column = sc.nextInt();

        System.out.println("Enter the row and columns of Matrix B:" );
        int b_row = sc.nextInt();
        int b_column = sc.nextInt();

        System.out.println("Enter the elements of the Matrix A (Total elements: " + (a_row * a_column) + " ): ");
        int a[][] = new int[a_row][a_column];
        for(int i = 0; i < a_row; i++){
            for (int j = 0; j < a_column; j++) {
                a[i][j] = sc.nextInt();
            }
        } 

        System.out.println("Enter the elements of the Matrix B (Total elements: " + (b_row * b_column) + " ): ");
        int b[][] = new int[b_row][b_column];
        for(int i = 0; i < b_row; i++){
            for (int j = 0; j < b_column; j++) {
                   b[i][j] = sc.nextInt();
            }
        }

        System.out.println("The matrix A:");
        for(int i = 0; i < a_row; i++){
            System.out.print("[ ");
            for (int j = 0; j < a_column; j++) {
                if(j != a_column - 1) System.out.print(a[i][j] + " ");
                else System.out.print(a[i][j]);
            }
            System.out.println(" ]");
        } 

        System.out.println("The matrix B:");
        for(int i = 0; i < b_row; i++){
            System.out.print("[ ");
            for (int j = 0; j < b_column; j++){
                if(j != b_column - 1) System.out.print(b[i][j] + " ");
                else System.out.print(b[i][j]);
            }
            System.out.println(" ]");
        } 
        
        if(a_column != b_row){
            System.out.println("Matrix Multiplication impossible!"); 
            return;
        }
        int c[][] = new int[a_row][b_column];
        System.out.println("The resultant matrix:");
        for(int i = 0; i < a_row; i++){
            System.out.print("[ ");
            for(int j = 0; j < b_column; j++){
                c[i][j] = 0;
                for(int k = 0; k < b_row; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
                if(j != b_column - 1) System.out.print(c[i][j] + " ");
                else System.out.print(c[i][j]);
            }
            System.out.println(" ]");
        }

    }
}
