package it.corsojava.insiemi;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {

    public static void main(String[] args) {
        try {
            long javaFilesCount = 0;

            Path root = Path.of("c:/corsojava/progetti");

            Deque<Path> directories=new LinkedList<Path>();
            directories.addFirst(root);
            while(!directories.isEmpty()) {
                Path currentDir = directories.pollFirst();
                System.out.println("Searching into " + currentDir.toString());
                DirectoryStream<Path> filesList = Files.newDirectoryStream(currentDir);

                for (Path p : filesList) {
                    if (!Files.isDirectory(p)) {
                        if (p.toString().endsWith(".java")) javaFilesCount++;
                    }else{
                        directories.addFirst(p);
                    }

                }
            }

            System.out.println("Java files: " + javaFilesCount);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
