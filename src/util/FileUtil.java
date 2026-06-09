package util;

import User.User;

import java.io.*;
import java.util.List;

public final class FileUtil {

    private static final String FILE_PATH = "users.txt";

    // 创建文件
    public static void initFile() {

        File file = new File(FILE_PATH);

        try {

            if (!file.exists()) {

                file.createNewFile();

                System.out.println("用户文件创建成功");
            }

        } catch (IOException e) {

            System.out.println("文件创建失败");

            e.printStackTrace();
        }
    }

    // 读取文件
    public static void loadUsers(List<User> users) {

        try (BufferedReader br =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] arr = line.split(",");

                if (arr.length == 2) {

                    User user = new User(arr[0], arr[1]);

                    users.add(user);
                }
            }

        } catch (IOException e) {

            System.out.println("读取用户失败");

            e.printStackTrace();
        }
    }

    // 保存一个用户
    public static void saveUser(User user) {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(FILE_PATH, true))) {

            bw.write(user.getAccount()
                    + ","
                    + user.getPassword());

            bw.newLine();

        } catch (IOException e) {

            System.out.println("保存用户失败");

            e.printStackTrace();
        }
    }
}