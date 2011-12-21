package ma.norsys.formation.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import ma.norsys.formation.entities.Question;
import ma.norsys.formation.entities.Questionnaire;
import ma.norsys.formation.entities.Response;
import ma.norsys.formation.entities.Subscriber;
import ma.norsys.formation.entities.Topic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 
 * @author technomaker04
 *
 */
@ContextConfiguration(locations = { "classpath:spring-test-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class QuestionnaireDaoImplTest {
	@Autowired
	IDaoQuestionnaire daoQuestionnaire;
	@Autowired
	IDaoTopic daoTopic;

	/**
	 * Etant donné un questionnaire dont on connait l'id, si on recherche ce
	 * questionnaire dans la bd alors le resultat doit bien etre ce meme
	 * questionnaire
	 * 
	 * @throws Exception
	 */

	@Test
	public void testFindQuestionnaire() throws Exception {
		createQuestionnaire();
		Questionnaire questionnaire = daoQuestionnaire.findQuetinnaireById(1L);
		Assert.assertNotNull(questionnaire);
		Assert.assertEquals(1L, questionnaire.getIdQuestionnaire());

	}

	/**
	 * crée un questionnaire pour le test
	 */
	private void createQuestionnaire() {

		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setIdQuestionnaire(1L);
		Topic topic = new Topic();
		topic.setIdTopic(1L);
		topic.setLibelle("JAVA");

		Response res1 = new Response(1, "Compilte et Interprete", true);
		Response res2 = new Response(2, "Interprete", false);
		Response res3 = new Response(3, "Compile", false);
		List<Response> lesReponses = new ArrayList<Response>();
		lesReponses.add(res1);
		lesReponses.add(res2);
		lesReponses.add(res3);

		Question qte = new Question(1, "Java est un langage", lesReponses);
		List<Question> lesQestions = new ArrayList<Question>();
		lesQestions.add(qte);
		topic.setLesQuestions(lesQestions);
		daoTopic.addTopic(topic);
		// list des subscribers
		List<Subscriber> subscribers = new ArrayList<Subscriber>();
		Subscriber subscriber = new Subscriber();
		subscriber.setIdSubscriber(1L);
		subscriber.setEmail("khattary11@gmail.com");
		subscribers.add(subscriber);

		questionnaire.setSubscribers(subscribers);
		questionnaire.setTopic(topic);
		daoQuestionnaire.addQuestionnaire(questionnaire);

	}

	/**
	 * Etant donné un utlilisateur dont l'id est (1L) si on recherche par id cet
	 * utilisateur alors le resultat doit etre l'utilisateur dont email
	 * "khattary11@gmail.com"
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindUser() throws Exception {
		Subscriber subscriberTrouve = daoQuestionnaire.findSubscriberById(1L);
		assertNotNull(subscriberTrouve);
		assertEquals("khattary11@gmail.com", subscriberTrouve.getEmail());
	}
}
