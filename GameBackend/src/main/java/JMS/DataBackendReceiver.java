package JMS;

import Entity.Roster;
import Service.RosterService;
import com.owlike.genson.Genson;
import Entity.BattleBro;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.inject.Inject;
import javax.jms.*;

public class DataBackendReceiver implements MessageListener {

        private Connection connection;
        private Session session;
        private MessageProducer producer;
        private Genson serializer;

        @Inject
        private RosterService rosterService;

    public DataBackendReceiver() throws JMSException {
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
            Roster roster = serializer.deserialize(json, Roster.class);
            rosterService.updateRoster(roster);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
