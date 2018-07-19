package com.example.designpartten.adapter;

/**
 * Created by James on 2018/7/17.
 */
public class SiginForThirdService extends SiginService {
    public ResultMsg loginForQQ(String openId){
        //1.openId是全局唯一，可以当做用户名
        //2. 密码默认为qq_empty 内部的，外部不知道
        //3. 注册（原有系统创建一个用户）
        //ResultMsg msg = super.regist(openId,null);
        //4. 调用原来的登录方法
        //msg =super.login(openId,null);
        //return msg;
        return loginForRegister(openId,null);
    }

    public ResultMsg loginForWechart(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，然后重新登录一次
        return null;
    }

    public ResultMsg loginForTelehone(String telephone,String code){
        return null;
    }

    /**
     * 注册后马上登录
     * @param username
     * @param password
     * @return
     */
    public ResultMsg loginForRegister(String username,String password){
        ResultMsg msg = super.regist(username,password);
        //4. 调用原来的登录方法
        msg =super.login(username,password);
        return msg;
    }

}
