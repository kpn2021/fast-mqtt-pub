package cn.kpn.fastmqttpub;

import lombok.extern.slf4j.Slf4j;
import net.dreamlu.iot.mqtt.codec.MqttQoS;
import net.dreamlu.iot.mqtt.spring.client.MqttClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class PubQos2Msg {
    @Autowired
    private MqttClientTemplate template;


    @Scheduled(fixedRate = 8000)
    public void sendTest() {
        String msg = "qos2测试消息" + System.currentTimeMillis();
        boolean pubOk = template.publish("test/once/msg",
                ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)),
                MqttQoS.EXACTLY_ONCE);
        log.info("mqtt消息:{},下发结果:{}", msg, pubOk);
    }
}
