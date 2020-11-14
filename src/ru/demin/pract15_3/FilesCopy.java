package ru.demin.pract15_3;

import ru.demin.pract15_1.MyLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;

public class FilesCopy {

    private static void _copy(Path cur_dir, Path into_dir) {
        try {
            Files.copy(cur_dir, into_dir, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            MyLogger.log(e.toString(), Level.WARNING);
        }
    }

    public static void copy(String cur_dir, String into_dir) throws IOException {
        Path cur_path = Paths.get(cur_dir);
        Path into_path = Paths.get(into_dir);

        Files.walk(cur_path).forEach(cur_p -> {
            _copy(cur_p,
                    into_path.resolve(
                        cur_path.relativize(cur_p)
                    )
            );
        });
    }

}
