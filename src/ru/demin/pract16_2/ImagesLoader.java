package ru.demin.pract16_2;

import org.jsoup.Jsoup;
import ru.demin.pract15_1.MyLogger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImagesLoader {
    private final List<String> sourcesUrl;
    private final String pathToDir;

    public ImagesLoader(List<String> sourcesUrl, String pathToDir) {
        this.sourcesUrl = sourcesUrl;
        this.pathToDir = pathToDir;
    }

    public List<String> downloadAllImages() {
        ArrayList<String> listOfName = new ArrayList<>();
        for(var imageUrl: sourcesUrl) {
            try {
                byte[] bytes = Jsoup.connect(imageUrl)
                        .ignoreContentType(true)
                        .execute().bodyAsBytes();

                ByteBuffer buff = ByteBuffer.wrap(bytes);
                String fileName = getNameOfImageFromUrl(imageUrl);

                if(setBufferBytesImage(buff, fileName)) {
                    listOfName.add(fileName);
                }
            } catch (IOException exception) {
                MyLogger.log(exception.getMessage(), Level.WARNING);
            }
        }

        return listOfName;
    }

    private boolean setBufferBytesImage(
            ByteBuffer imageDataBytes,
            String fileName
    ) throws IOException {
        final String pathToImage = pathToDir+"/"+fileName;
        File dir = new File(pathToDir);

        if(!dir.exists()) {
            boolean res = dir.mkdir();
            if(!res) {
                throw new IOException("Cannot create dir on path: " + pathToDir );
            }
        }

        File image = new File(pathToImage);
        BufferedImage bufferedImage;

        String[] parts = fileName.split("\\.");
        String format = parts[parts.length-1];

        InputStream in = new ByteArrayInputStream(imageDataBytes.array());
        bufferedImage = ImageIO.read(in);
        return ImageIO.write(bufferedImage, format, image);
    }

    private static String getNameOfImageFromUrl(String url) {
        final String regex = "[a-zA-Z0-9._-]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if(matcher.find()) {
            return matcher.group();
        }

        return "";
    }


}
