package org.example.chapter9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Matrix {
    private double[][] matrix;

    public Matrix(int n, int m) {
        this.matrix = new double[n][m];
    }

    public void save(String filename) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(matrix.length + " " + matrix[0].length);
            for (double[] row : matrix) {
                for (double num : row) {
                    printWriter.print(num + " ");
                }
                printWriter.println();
            }
        }
    }

    public static Matrix read(String filename) throws IOException, ExceptionWrongMatrixValues, ExceptionWrongMatrixDimension {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String[] dimensions = bufferedReader.readLine().split(" ");
            if (dimensions.length != 2) throw new ExceptionWrongMatrixValues("Invalid matrix dimensions");

            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);

            Matrix matrix = new Matrix(rows, cols);
            for (int i = 0; i < rows; i++) {
                String line = bufferedReader.readLine();
                //ExceptionWrongMatrixValues
                if (line == null) throw new ExceptionWrongMatrixValues("데이터가 행렬이 아닙니다");

                String[] numbers = line.split(" ");
                //ExceptionWrongMatrixDimension
                if (numbers.length != cols) throw new ExceptionWrongMatrixValues("행렬이 일치하지 않습니다.");

                for (int j = 0; j < cols; j++) {
                    try {
                        matrix.matrix[i][j] = Double.parseDouble(numbers[j]);
                    } catch (NumberFormatException e) {
                        throw new ExceptionWrongMatrixValues("숫자형식이 아닌 값 포함");
                    }
                }
            }
            if (bufferedReader.readLine() != null) throw new ExceptionWrongMatrixDimension("행렬데이터 보다 큽니다");
            return matrix;
        }
    }


    public Matrix sum(Matrix m) {
        if (this.matrix.length != m.matrix.length || this.matrix[0].length != m.matrix[0].length) {
            return null;
        }

        Matrix result = new Matrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                result.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix product(Matrix m) {
        if (this.matrix[0].length != m.matrix.length) {
            return null;
        }

        Matrix result = new Matrix(this.matrix.length, m.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < m.matrix[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < this.matrix[0].length; k++) {
                    sum += this.matrix[i][k] * m.matrix[k][j];
                }
                result.matrix[i][j] = sum;
            }
        }
        return result;
    }

    // For testing
    public void print() {
        for (double[] row : matrix) {
            for (double num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            Matrix matrix1 = new Matrix(2, 2);
            matrix1.matrix[0][0] = 1;
            matrix1.matrix[0][1] = 2;
            matrix1.matrix[1][0] = 3;
            matrix1.matrix[1][1] = 4;



            Matrix matrix2 = new Matrix(2, 2);
            matrix2.matrix[0][0] = 5;
            matrix2.matrix[0][1] = 6;
            matrix2.matrix[1][0] = 7;
            matrix2.matrix[1][1] = 8;

//            matrix1.save("matrix1.txt");
            Matrix readMatrix = Matrix.read("matrix1.txt");
            readMatrix.print();

            Matrix sumMatrix = matrix1.sum(matrix2);
            if (sumMatrix != null) {
                sumMatrix.print();
            }

            Matrix productMatrix = matrix1.product(matrix2);
            if (productMatrix != null) {
                productMatrix.print();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExceptionWrongMatrixDimension e) {
            e.printStackTrace();
        } catch (ExceptionWrongMatrixValues e) {
            e.printStackTrace();
        }
    }
}
