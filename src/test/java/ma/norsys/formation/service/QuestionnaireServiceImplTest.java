package ma.norsys.formation.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import ma.norsys.formation.dao.IDaoQuestionnaire;
import ma.norsys.formation.entities.Questionnaire;
import ma.norsys.formation.entities.Subscriber;

import org.junit.Assert;
import org.junit.Before;
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
public class QuestionnaireServiceImplTest {
	@Autowired
	private IServiceQuestionnaire myService;
	@Autowired
	private IDaoQuestionnaire daoQuestionnaire;

	@Before
	public void setup() throws Exception {
		// creation du mock
		daoQuestionnaire = mock(IDaoQuestionnaire.class);
		// preparation des objets a retourner
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setIdQuestionnaire(1L);

		Subscriber subscriber = new Subscriber();
		subscriber.setIdSubscriber(1L);
		subscriber.setEmail("khattary11@gmail.com");
		// ajout du mock
		myService.setDaoQuestionnaire(daoQuestionnaire);
		// simulation du resultat lors de l'appel
		when(daoQuestionnaire.findQuetinnaireById(1L))
				.thenReturn(questionnaire);

		when(daoQuestionnaire.findSubscriberById(1L)).thenReturn(subscriber);
	}

	/**
	 * Etant donné un questionnaire dont on connait l'id, si on recherche ce
	 * questionnaire a partire du service alors le resultat doit bien etre ce
	 * meme questionnaire
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindQuestionnaire() throws Exception {
		Questionnaire questionnaireTrouve = myService.findQuetinnaireById(1L);
		Assert.assertEquals(1L, questionnaireTrouve.getIdQuestionnaire());
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
		Subscriber subscriberTrouve = myService.findSubscriberById(1L);
		Assert.assertEquals("khattary11@gmail.com", subscriberTrouve.getEmail());
	}
}
