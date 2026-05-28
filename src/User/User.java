package User;

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
    public void signIn(String account , String password){
        User tempUser = new User(account , password);
        for (User i:Database.Userdata) {
            if (tempUser.getAccount().equals(i.getAccount())&& tempUser.getPassword().equals(password)){
                System.out.println("登陆成功！");
                break;
            }
        }
        System.out.println("用户未注册。");
        //在此处应该设置一个信号来判断是否允许进入程序，可将方法改为布尔类型，用输出的值来进行判断
    }
}
