package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class ParseDataTest {

	private static Parser parser;

	@Before
	public void prepare() {
		parser = new ParseData(new JSONObject());
	}

	@Test
	public void parseTestCaseOne() {
		String data = "org.occ.loans.ws.backend.ClientsResource : clients search: 597403365";
		JSONObject expected, actual;
		expected = new JSONObject();
		JSONObject dataJson = new JSONObject();
		dataJson.put("message", "clients search: 597403365");
		expected.put("class", "org.occ.loans.ws.backend.ClientsResource");
		expected.put("data", dataJson);
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseTwo() {
		String data = "o.o.l.d.m.client.CanClientApplyForLoanRejectReason : Client{id=95429} can apply result: OPEN_LOANS_LIMIT";
		JSONObject expected, actual;
		expected = new JSONObject();
		
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseThree() {
		String data = "o.o.loans.ge.integr.monemovers.MoneyMoversService : getting loan payment info for personalId: 41001011343";
		JSONObject expected, actual;
		expected = new JSONObject();

		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseFour() {
		String data = "org.occ.common.service.CommandServiceBean : --> RequestTmpPasswordCommand[email=lipsothe@gmail.com]";
		JSONObject expected, actual;
		expected = new JSONObject();

		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseFive() {
		String data = "org.occ.common.events.DomainEvents : Event LoanApplicationFlowStateChanged[application=LoanApplication{id=1209588},when=2016-03-24T15:26:18.615,oldState=NEW] ";
		JSONObject expected, actual;
		expected = new JSONObject();

		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseSix() {
		String data = "org.occ.common.events.DomainEvents : Event TemporaryPasswordRequestedEvent[client=Client{id=97140},password=*********]";
		JSONObject expected, actual;
		expected = new JSONObject();

		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

}
