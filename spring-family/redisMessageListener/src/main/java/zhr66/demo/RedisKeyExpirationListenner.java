package zhr66.demo;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class RedisKeyExpirationListenner extends KeyExpirationEventMessageListener {


    public RedisKeyExpirationListenner(RedisMessageListenerContainer listenerContainer) {

        super(listenerContainer);
    }


    /**
     * 针对 redis 数据失效时间，进行数据处理
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {

        //获取到失效的key，进行取消订单业务处理
        String expiredKey = message.toString();
        System.out.println(expiredKey);
    }
}
