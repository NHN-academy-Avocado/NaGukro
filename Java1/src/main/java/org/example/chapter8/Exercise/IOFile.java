package org.example.chapter8.Exercise;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOFile {
    private String filename;

    public IOFile(String filename) {
        this.filename = filename;
    }

    public int countLines() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + filename);
        } catch (IOException e) {
            System.err.println("파일을 읽는 도중 오류가 발생했습니다: " + filename);
        }
        return 0;
    }

    public void write(OutputStream os) {
        try (InputStream is = new FileInputStream(filename)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + filename);
        } catch (IOException e) {
            System.err.println("파일을 쓰는 도중 오류가 발생했습니다: " + filename);
        }
    }

    public void print() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + filename);
        } catch (IOException e) {
            System.err.println("파일을 출력하는 도중 오류가 발생했습니다: " + filename);
        }
    }

    public void copy(String newFilename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
             PrintWriter printWriter = new PrintWriter(new FileWriter(newFilename))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                printWriter.println(s);
            }
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + filename);
        } catch (IOException e) {
            System.err.println("파일을 " + newFilename + "(으)로 복사하는 도중 오류가 발생했습니다.");
        }
    }

    public void delete() {
        Path path = Paths.get(filename);
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.err.println("파일을 삭제하는 도중 오류가 발생했습니다: " + filename);
        }
    }

    public static void main(String[] args) {
        IOFile file = new IOFile("test.txt");

        System.out.println("파일의 줄 수: " + file.countLines());
        file.print();
        file.copy("test_copy.txt");

        try (OutputStream os = new FileOutputStream("test_output.txt")) {
            file.write(os);
        } catch (FileNotFoundException e) {
            System.err.println("출력 파일을 생성하는데 오류가 발생했습니다: test_output.txt");
        } catch (IOException e) {
            System.err.println("출력 파일에 쓰는 도중 오류가 발생했습니다: test_output.txt");
        }

        // 아래 줄의 주석을 해제하여 delete 메서드를 테스트할 수 있습니다.
        // file.delete();
    }
}
