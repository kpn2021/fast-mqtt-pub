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
public class PubQos1Msg {
    @Autowired
    private MqttClientTemplate template;


    @Scheduled(fixedRate = 5000)
    public void sendTest() {
        String msg = "qos1测试-" + System.currentTimeMillis();
        boolean pubOk = template.publish("plc001/ctrl/21eur",
                ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)),
                MqttQoS.AT_LEAST_ONCE);
        log.info("mqtt消息:{},下发结果:{}", msg, pubOk);
    }
}
