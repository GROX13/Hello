package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwinoLogParserTest {

	private static Parser parser;

	@BeforeClass
	public static void initialize() {
		parser = TwinoLogParser.instance();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testParseVoid() {
		String log = "2016-03-24 15:26:13.454  INFO 6543 [http-nio-8080-exec-42]  --- org.occ.common.service.CommandServiceBean : <-- VoidResponse[] 5ms";

		JSONObject result = parser.parse(log);

		JSONObject jsonLog = new JSONObject();
		jsonLog.put("dateTime", "2016-03-24 15:26:13.454");
		jsonLog.put("level", "INFO");
		jsonLog.put("pId", "6543");
		jsonLog.put("thread", "http-nio-8080-exec-42");
		jsonLog.put("class", "org.occ.common.service.CommandServiceBean");
		jsonLog.put("direction", "<--");
		jsonLog.put("VoidResponse", new JSONObject());
		jsonLog.put("time", "5ms");

		assertEquals("Parse void response result mismatch!", jsonLog, result);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testParseVoidWithComplexLog() {
		String log = "2016-03-24 15:26:14.478  INFO 6543 [http-nio-8080-exec-15] cid:435538 --- org.occ.common.service.CommandServiceBean : <-- " +
				"LoanApplicationBean[id=1209588,clientId=435538,clientFullName=მარიამ მამადაშვილი,clientMobilePhone=577320478," +
				"term=30 DAYS,amount=1000,applicationType=WEB,status=OPEN,confirmed=false,confirmationDate=<null>,resolution=<null>," +
				"rejectReason=<null>,resolutionMessage=<null>,referer=<null>,created=2016-03-24T15:26:18.617,ip=94.100.237.147,manualWarnings=" +
				"<null>,closeDate=<null>,creditgSuccessScore=<null>,creditgUsedProviders=<null>,loansCount=2,creditScore=<null>,testScorecardCreditScore" +
				"=<null>,askedAmount=1000,askedTerm=30 DAYS,calculatedCreditLimit=<null>,additionalAmountApplication=false,flowState=NEW,flowStateDetails=<null>" +
				",flowStateStartDateTime=2016-03-24T15:26:18.618,brokerPartnerName=<null>,iovationBlackbox=<null>] 9ms";

		JSONObject result = parser.parse(log);

		JSONObject jsonLog = new JSONObject();
		JSONObject temp;
		jsonLog.put("dateTime", "2016-03-24 15:26:14.478");
		jsonLog.put("level", "INFO");
		jsonLog.put("pId", "6543");
		jsonLog.put("thread", "http-nio-8080-exec-15");
		jsonLog.put("cid", "435538");
		jsonLog.put("class", "org.occ.common.service.CommandServiceBean");
		jsonLog.put("direction", "<--");
		jsonLog.put("time", "9ms");
		
		temp = new JSONObject();
		temp.put("id", "1209588");
		temp.put("referer", null);
		temp.put("clientId", "435538");
		temp.put("clientFullName", "მარიამმამადაშვილი");
		temp.put("clientMobilePhone", "577320478");
		temp.put("term", "30DAYS");
		temp.put("amount", "1000");
		temp.put("applicationType", "WEB");
		temp.put("status", "OPEN");
		temp.put("confirmed", "false");
		temp.put("confirmationDate", null);
		temp.put("resolution", null);
		temp.put("rejectReason", null);
		temp.put("resolutionMessage", null);
		temp.put("created", "2016-03-24T15:26:18.617");
		temp.put("ip", "94.100.237.147");
		temp.put("manualWarnings", null);
		temp.put("closeDate", null);
		temp.put("creditgSuccessScore", null);
		temp.put("creditgUsedProviders", null);
		temp.put("loansCount", "2");
		temp.put("creditScore", null);
		temp.put("testScorecardCreditScore", null);
		temp.put("askedAmount", "1000");
		temp.put("askedTerm", "30DAYS");
		temp.put("calculatedCreditLimit", null);
		temp.put("additionalAmountApplication", "false");
		temp.put("flowState", "NEW");
		temp.put("flowStateDetails", null);
		temp.put("flowStateStartDateTime", "2016-03-24T15:26:18.618");
		temp.put("brokerPartnerName", null);
		temp.put("iovationBlackbox", null);

		jsonLog.put("LoanApplicationBean", temp);

		assertEquals("Parse void response result mismatch!", jsonLog, result);
	}

}
