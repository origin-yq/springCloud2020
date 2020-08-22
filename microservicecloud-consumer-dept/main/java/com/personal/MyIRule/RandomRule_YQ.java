package com.personal.MyIRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * 自定义轮询算法
 */
public class RandomRule_YQ  extends AbstractLoadBalancerRule {

    public RandomRule_YQ() {
    }

    /**
     * 自定义轮询需求：要求每台机器的服务被调用5次
     */
    private int total = 0;  //服务被调用次数
    private int index = 0;   //对于机器索引下标

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {   //判断当前线程是否被中断，中断返回null
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

              //  int index = this.rand.nextInt(serverCount);
              //  server = (Server)upList.get(index);
                if(total < 5 ){
                    server = getServer(upList);
                }else{
                    total = 0;
                    index ++;
                    if(index < allList.size()){
                        server = getServer(upList);
                    }else{
                        index = 0;
                        server = getServer(upList);
                    }

                }
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    private Server getServer(List<Server> upList) {
        Server server;
        server = (Server) upList.get(index);
        total++;
        return server;
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
