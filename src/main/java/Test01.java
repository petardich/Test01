import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class Test01 {

    public static void main(String[] args) throws IOException {
//        copyFile("Julia.jpg", "dir/Juliaaa.jpg");

        System.out.println(1|2>>3);
        System.out.println("Test git");
        System.out.println("Test git 2");


    }

    public static void addPoints(List<? extends ColoredPoint2D> from, List<? super ColoredPoint2D> to) {
        to.addAll(from);
    }

    private static void copyFile(String from, String to) throws IOException {
        Path fileFrom = Paths.get(from);
        Path fileTo = Paths.get(to);
        InputStream inputStream = Files.newInputStream(fileFrom);
        OutputStream outputStream = Files.newOutputStream(fileTo);
        byte[] buf = new byte[1024];
        int numberOfBytesRead;
        while ((numberOfBytesRead = inputStream.read(buf)) > 0) {
            outputStream.write(buf, 0, numberOfBytesRead);
        }
    }

    private static void executorServiceTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future1 = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Hello1";
        });
        Future<String> future2 = executorService.submit(() -> {
            Thread.sleep(100);
            return "Hello2";
        });
        Future<String> future3 = executorService.submit(() -> "Hello3");
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

    private static void createAndWriteToFile() {
        Path newDir = Paths.get("dir");
        System.out.println("Absolute? " + newDir.isAbsolute());
        Path newFile = Paths.get("dir/newfile.txt");
        try {
            Files.createDirectory(newDir);
            Files.createFile(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(newFile.toFile())) {
            fileWriter.append("Hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
