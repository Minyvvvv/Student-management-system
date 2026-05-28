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
        for ()
    }
}
