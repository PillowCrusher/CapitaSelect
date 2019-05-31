package JMS;

import com.owlike.genson.Genson;
import com.sun.media.sound.DataPusher;
import entity.BattleBro;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Datapublisher {
    private Connection connection;
    private Session session;
    private MessageProducer producer;
    private Genson serializer;

    public Datapublisher() throws JMSException {

        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = factory.createConnection();
        connection.setClientID("BattleBrothers");
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue newQueue = session.createQueue("BattleBrosData");
        producer = session.createProducer(newQueue);
        serializer = new Genson();
    }

    public void SendBroUpdate(BattleBro bro) throws JMSException {
        producer.send(session.createTextMessage(serializer.serialize(bro)));
    }
}
