package User;

import java.lang.Character;

public class User {
    private String account;
    private String password;
    //关于账号密码的规则：
    //1.没有账号需要注册
    //2.密码长度为18位以内，必须为数字字母符号三种的组合
    //3.对密码进行转译加密处理，后期需接入数据库来对用户密码进行存储
    //4.

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User() { }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //登陆方法：
    public int signIn(String account , String password){
        User tempUser = new User(account , password);
        for (User i:Database.Userdata) {
            if (tempUser.getAccount().equals(i.getAccount())){
                if (tempUser.getPassword().equals(i.getPassword())){
                    System.out.println("登陆成功！");
                    return 0; //登陆成功
                }else {
                    System.out.println("密码错误，请重新输入！");
                    return 2;
                }
            }

        }
        System.out.println("用户未注册。");
        return 2;
    }
    public static boolean exist(String account) {
        for (User u : Database.Userdata) {
            if (u.getAccount().equals(account)){
                System.out.println("账号重复。");
                return true;
            }
        }
        return false;
    }
    public static boolean Password_verification(String password) {
        //判断密码位数是否符合要求
        if (password.length() < 6 || password.length() > 18 ) {
            return false;
        }

        //三种字符组合：数字，字母，符号
        boolean hasDigit = false;
        boolean hasLetter = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLetter(c)) {
                hasLetter = true;
            }else {
                hasSpecial = true;
            }

        }
        return hasDigit && hasLetter && hasSpecial;

    }
}
