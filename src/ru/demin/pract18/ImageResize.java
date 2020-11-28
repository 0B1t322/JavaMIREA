package ru.demin.pract18;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ImageResize {
    private final ArrayDeque<File> filesPool;
    private final String dstFolder;

    synchronized public File getFile() {
        return filesPool.pollFirst();
    }

    public ImageResize(File[] files, String dstFolder) {
        filesPool = new ArrayDeque<File>(Arrays.asList(files));
        this.dstFolder = dstFolder;
    }

    public void resize() throws IOException {
        long start = System.currentTimeMillis();
        File file;
        while ( (file = getFile() ) != null ) {
            BufferedImage image = ImageIO.read(file);
            if (image == null) return;

            int newWidth = image.getWidth() / 2;
            int newHeight = (int) Math.round(
                    image.getHeight() / (image.getWidth() / (double) newWidth)
            );

            BufferedImage newImage = new BufferedImage(
                    newWidth, newHeight, BufferedImage.TYPE_INT_RGB
            );

            int widthStep = image.getWidth() / newWidth;
            int heightStep = image.getHeight() / newHeight;

            for (int x = 0; x < newWidth; x++) {
                for (int y = 0; y < newHeight; y++) {
                    int rgb = image.getRGB(x * widthStep, y * heightStep);
                    newImage.setRGB(x, y, rgb);
                }
            }

            File newFile = new File(dstFolder + "/" + file.getName());
            ImageIO.write(newImage, "jpg", newFile);
        }
        long duration = System.currentTimeMillis() - start;

        System.out.println("Duration: " + duration);
    }
}
