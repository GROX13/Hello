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
		dataJson.put("message", "clientssearch:597403365");
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
		JSONObject dataJson = new JSONObject();
		dataJson.put("message", "Client{id=95429}canapplyresult:OPEN_LOANS_LIMIT");
		expected.put("class", "o.o.l.d.m.client.CanClientApplyForLoanRejectReason");
		expected.put("data", dataJson);
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseThree() {
		String data = "o.o.loans.ge.integr.monemovers.MoneyMoversService : getting loan payment info for personalId: 41001011343";
		JSONObject expected, actual;
		expected = new JSONObject();
		JSONObject dataJson = new JSONObject();
		dataJson.put("message", "gettingloanpaymentinfoforpersonalId:41001011343");
		expected.put("class", "o.o.loans.ge.integr.monemovers.MoneyMoversService");
		expected.put("data", dataJson);
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseFour() {
		String data = "org.occ.common.service.CommandServiceBean : --> RequestTmpPasswordCommand[email=lipsothe@gmail.com]";
		JSONObject expected, actual;
		expected = new JSONObject();
		JSONObject temp = new JSONObject();
		temp.put("email", "lipsothe@gmail.com");
		expected.put("RequestTmpPasswordCommand", temp);
		expected.put("class", "org.occ.common.service.CommandServiceBean");
		expected.put("direction", "-->");
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseFive() {
		String data = "org.occ.common.events.DomainEvents : Event LoanApplicationFlowStateChanged[application=LoanApplication{id=1209588},when=2016-03-24T15:26:18.615,oldState=NEW]";
		JSONObject expected, actual;
		expected = new JSONObject();
		JSONObject temp = new JSONObject();
		temp.put("application", "LoanApplication{id=1209588}");
		temp.put("when", "2016-03-24T15:26:18.615");
		temp.put("oldState", "NEW");
		expected.put("EventLoanApplicationFlowStateChanged", temp);
		expected.put("class", "org.occ.common.events.DomainEvents");
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseSix() {
		String data = "org.occ.common.events.DomainEvents : Event TemporaryPasswordRequestedEvent[client=Client{id=97140},password=*********]";
		JSONObject expected, actual;
		expected = new JSONObject();
		JSONObject temp = new JSONObject();
		temp.put("client", "Client{id=97140}");
		temp.put("password", "*********");
		expected.put("EventTemporaryPasswordRequestedEvent", temp);
		expected.put("class", "org.occ.common.events.DomainEvents");
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseSeven() {
		String data = "org.occ.common.service.CommandServiceBean : <-- VoidResponse[] 13ms";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("VoidResponse", new JSONObject());
		expected.put("class", "org.occ.common.service.CommandServiceBean");
		expected.put("direction", "<--");
		expected.put("time", "13ms");
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseEight() {
		String data = "o.o.l.r.l.creditg.impl.CreditgApiClientHttp : Stored data: [[provider: geoIp, runSuccess: true, runEntryId: 1041738], " +
				"[provider: personalIdBlacklist, runSuccess: true, runEntryId: 1478238], [provider: creditinfo, runSuccess: true, runEntryId: 1478239]]";
		JSONObject actual = parser.parse(data);
		assertEquals("{\"data\":{\"message\":\"Storeddata:[[provider:geoIp,runSuccess:true,runEntryId:1041738]," +
				"[provider:personalIdBlacklist,runSuccess:true,runEntryId:1478238],[provider:creditinfo,runSuccess:true," +
				"runEntryId:1478239]]\"},\"class\":\"o.o.l.r.l.creditg.impl.CreditgApiClientHttp\"}", actual.toJSONString());
	}

}
