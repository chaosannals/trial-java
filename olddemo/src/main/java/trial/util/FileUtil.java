package trial.util;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtil {
    public static byte[] readAllBytes(String path) throws IOException {
        File f = new File(path);
        try (FileInputStream r = new FileInputStream(f)) {
            byte[] result = new byte[(int) f.length()];
            r.read(result);
            return result;
        }
    }

    public static String readAll(String path) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            StringBuilder b = new StringBuilder();
            char[] buffer = new char[1024];
            int n = 0;
            while ((n = r.read(buffer)) != -1) {
                String d = String.valueOf(buffer, 0, n);
                b.append(d);
            }
            return b.toString();
        }
    }

    public static List<String> listAllFile(File dir) {
        List<String> result = new ArrayList<String>();
        if (!dir.isDirectory()) {
            String msg = String.format("%s is not a directory", dir.getAbsolutePath());
            throw new IllegalArgumentException(msg);
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    result.addAll(listAllFile(f));
                } else {
                    result.add(f.getAbsolutePath());
                }
            }
        }

        return result;
    }

    public static List<String> listAllFile(String path) {
        File dir = new File(path);
        return listAllFile(dir);
    }

    public static List<String> listAllDir(File dir) {
        List<String> result = new ArrayList<String>();
        if (!dir.isDirectory()) {
            String msg = String.format("%s is not a directory", dir.getAbsolutePath());
            throw new IllegalArgumentException(msg);
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    result.add(f.getAbsolutePath());
                    result.addAll(listAllDir(f));
                }
            }
        }

        return result;
    }

    public static List<String> listAllDir(String path) {
        File dir = new File(path);
        return listAllDir(dir);
    }

    public static List<String> listDir(File dir) {
        List<String> result = new ArrayList<String>();
        if (!dir.isDirectory()) {
            String msg = String.format("%s is not a directory", dir.getAbsolutePath());
            throw new IllegalArgumentException(msg);
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    result.add(f.getAbsolutePath());
                }
            }
        }
        return result;
    }

    public static List<Path> listDir(String path) {
        File dir = new File(path);
        List<Path> ps = new ArrayList<Path>();
        for (String p : listDir(dir)) {
            ps.add(Path.of(p).toAbsolutePath());
        }
        return ps;
    }

    public static void writeTo(String path, String content) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(content.getBytes());
        fos.close();
    }

    /**
     * 复制文件。
     * 
     * @param s
     * @param d
     * @throws IOException
     */
    public static void copyFile(String s, String d) throws IOException {
        File dp = Path.of(d).getParent().toFile();
        if (!dp.exists()) {
            dp.mkdirs();
        }

        FileInputStream fis = new FileInputStream(s);
        FileOutputStream fos = new FileOutputStream(d);
        try {
            byte[] buffer = new byte[1024];
            while (true) {
                int n = fis.read(buffer);
                if (n == -1) {
                    break;
                }
                fos.write(buffer, 0, n);
            }
        } finally {
            fis.close();
            fos.close();
        }
    }
}
