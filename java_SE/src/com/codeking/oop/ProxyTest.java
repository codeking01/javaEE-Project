package com.codeking.oop;

/**
 * @author : codeking
 * @date : 2022/9/8 17:28
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 先实例化真实用户的对象
        User user = new User();
        // 去代理这个访问
        Proxy proxy = new Proxy(user);
        proxy.network();
    }
}

interface Network {
    public abstract void network();
}

class User implements Network {
    @Override
    public void network() {
        System.out.println("真实上网！");
    }
}


class Proxy implements Network {
    private Network work;

    public Proxy(Network work) {
        this.work = work;
    }

    @Override
    public void network() {
        check();
        work.network();
    }

    private void check() {
        System.out.println("上网先检查！");
    }
}