package JMS;

import com.owlike.genson.Genson;
import entity.BattleBro;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Datareceiver implements MessageListener {

        private Connection connection;
        private Session session;
        private MessageProducer producer;
        private Genson serializer;

    public Datareceiver() throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connection = factory.createConnection();
            connection.setClientID("BattleBrothers");
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue newQueue = session.createQueue("BattleBrosData");
            serializer = new Genson();
            MessageConsumer consumer = session.createConsumer(newQueue);
            consumer.setMessageListener(this);
    }

    @Override
    public void onMessage(Message message) {
        try {
            String json = ((TextMessage) message).getText();
            BattleBro bro = serializer.deserialize(json,BattleBro.class);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
