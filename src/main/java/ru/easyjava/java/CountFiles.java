package ru.easyjava.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Example of filesystem based streams.
 */
public class CountFiles {
    /**
     * Counts directories in the root directory.
     * @return number of directories.
     * @throws IOException when something goes wrong.
     */
    public final long countTopDirectories() throws IOException {
        return Files.find(
                new File("/")
                        .toPath(),
                1,
                (p, a) -> a.isDirectory())
                .count();
    }

    /**
     * Counts directories in specified path.
     * @param path path to process.
     * @return number of directories.
     * @throws IOException when something goes wrong.
     */
    public final long countOnlyDirectories(final String path)
            throws IOException {
        return Files.list(
                new File(path)
                        .toPath())
                .filter(p -> p.toFile().isDirectory())
                .count();
    }

    /**
     * Counts files whose names are start with S.
     * @return number of files.
     * @throws IOException when smothing is wrong.
     */
    public final long countFilesStartingWithS() throws IOException {
        return Files.walk(new File("/").toPath())
                .filter(p -> p.toFile().isFile())
                .filter(p -> p.getFileName().startsWith("S"))
                .count();
    }
}
