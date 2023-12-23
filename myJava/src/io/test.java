package io;

import java.io.*;

public class test {
    public static void main(String[] args) {
        dataIO();
    }

    public void byteIO() {
        File file = new File("D://a/b/c");
        boolean mkdir = file.mkdirs();
        System.out.println("mkdir = " + mkdir);
        System.out.println("File.separator = " + File.separator);
        System.out.println("File.pathSeparator = " + File.pathSeparator);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("d://abc.txt");
            fileOutputStream = new FileOutputStream("d://z.txt");
            int[] arr1 = new int[3];
            arr1[0] = 1;
            arr1[1] = 2;
            arr1[2] = 3;
            int[] arr2 = new int[]{1, 2, 3};
            int[] arr3 = {4, 5, 6};
            byte[] bytes = new byte[fileInputStream.available()];
            int len = -1;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }

                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void charIO() {
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader("D://abc.txt");
            writer = new FileWriter("d://z.txt");
            char[] chars = new char[10];
            StringBuffer stringBuffer = new StringBuffer();
            int len = -1;
            while ((len = reader.read(chars)) != -1) {
                stringBuffer.append(chars, 0, len);
            }
            String s = stringBuffer.toString();
            String s1 = s.replaceAll("name", "lan").replaceAll("address", "xa");
            writer.write(s1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (writer != null) {

                    writer.close();
                }
                if (reader != null) {

                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void charBufferIO() {
        Reader reader = null;
        Writer writer = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            reader = new FileReader("D://abc.txt");
            writer = new FileWriter("d://z.txt");
            br = new BufferedReader(reader);
            bw = new BufferedWriter(writer);
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line);
            }
            String s = stringBuffer.toString();
            String s1 = s.replaceAll("name", "lan").replaceAll("address", "xa");
            writer.write(s1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null) {

                    bw.close();
                }
                if (br != null) {

                    br.close();
                }
                if (writer != null) {

                    writer.close();
                }
                if (reader != null) {

                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void dataIO() {
        try {
            File file = new File("d://test1.png");
            if (!file.exists()) {
                file.mkdir();
            }
            InputStream inputStream = new FileInputStream("d://test.png");
            FileOutputStream fileOutputStream = new FileOutputStream("d://test1.png");

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            byte[] bytes = new byte[10];
            int len = -1;
            while ((len = inputStream.read(bytes)) != -1) {
                dataOutputStream.write(bytes, 0, len);
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
