package cn.kpn.fastmqttpub;

import lombok.extern.slf4j.Slf4j;
import net.dreamlu.iot.mqtt.spring.client.MqttClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class PubQos0Msg {

    @Autowired
    private MqttClientTemplate client;


    @Scheduled(fixedRate = 3000)
    public void sendTest() {
        String msg = "33C:" + System.currentTimeMillis();
        boolean pubOk = client.publish("plc001/sensor/temperature",
                ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));
        log.info("mqtt消息:{},下发结果:{}", msg, pubOk);
    }
}
