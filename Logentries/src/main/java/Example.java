import me.giorgirokhadze.parser.Parser;
import me.giorgirokhadze.parser.twino.TwinoLogParser;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Example {

	private static Logger logger = LoggerFactory.getLogger("logentries");

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Parser p = TwinoLogParser.instance();
		
		String log0 = "INFO 6543 [http-nio-8080-exec-43]  --- org.occ.common.service.CommandServiceBean : --> " +
				"UpdateClientMainDataCommand[clientId=36287,gender=MALE,email=mirza.komakhidze@mail.ru,mobilePhone=555176793] ";
		
		String log1 = "INFO 6543 [http-nio-8080-exec-43]  --- org.occ.common.service.CommandServiceBean : <-- VoidResponse[] 6ms ";
		
		String log3 = "INFO 6543 [http-nio-8080-exec-15] cid:435538 --- org.occ.common.service.CommandServiceBean : <-- " +
				"LoanApplicationBean[id=1209588,clientId=435538,clientFullName=მარიამ მამადაშვილი,clientMobilePhone=577320478," +
				"term=30 DAYS,amount=1000,applicationType=WEB,status=OPEN,confirmed=false,confirmationDate=<null>,resolution=<null>," +
				"rejectReason=<null>,resolutionMessage=<null>,referer=<null>,created=2016-03-24T15:26:18.617,ip=94.100.237.147,manualWarnings=" +
				"<null>,closeDate=<null>,creditgSuccessScore=<null>,creditgUsedProviders=<null>,loansCount=2,creditScore=<null>,testScorecardCreditScore" +
				"=<null>,askedAmount=1000,askedTerm=30 DAYS,calculatedCreditLimit=<null>,additionalAmountApplication=false,flowState=NEW,flowStateDetails=<null>" +
				",flowStateStartDateTime=2016-03-24T15:26:18.618,brokerPartnerName=<null>,iovationBlackbox=<null>] 9ms";
		
		String log4 = "INFO 6543 [http-nio-8080-exec-15] cid:435538 --- org.occ.common.service.CommandServiceBean : --> ApplyForLoanCommand[clientId=435538," +
				"term=30 DAYS,askedTerm=30 DAYS,amount=1000,askedAmount=1000,applicationType=WEB,when=2016-03-24T15:26:18.615,brokerPartnerName=<null>,iovationBlackbox=<null>]";


		JSONObject jLog0 = new JSONObject();
		JSONObject jLog1 = new JSONObject();
		JSONObject jLog3 = new JSONObject();
		JSONObject jLog4 = new JSONObject();

		JSONObject temp;

		jLog0.put("level", "INFO");
		jLog1.put("level", "INFO");
		jLog3.put("level", "INFO");
		jLog4.put("level", "INFO");

		jLog0.put("pId", "6543");
		jLog1.put("pId", "6543");
		jLog3.put("pId", "6543");
		jLog4.put("pId", "6543");

		jLog0.put("thread", "http-nio-8080-exec-43");
		jLog1.put("thread", "http-nio-8080-exec-43");
		jLog3.put("thread", "http-nio-8080-exec-15");
		jLog4.put("thread", "http-nio-8080-exec-15");

		jLog0.put("cid", null);
		jLog1.put("cid", null);
		jLog3.put("cid", "435538");
		jLog4.put("cid", "435538");

		jLog0.put("class", "org.occ.common.service.CommandServiceBean");
		jLog1.put("class", "org.occ.common.service.CommandServiceBean");
		jLog3.put("class", "org.occ.common.service.CommandServiceBean");
		jLog4.put("class", "org.occ.common.service.CommandServiceBean");

		temp = new JSONObject();
		temp.put("clientId", "36287");
		temp.put("gender", "MALE");
		temp.put("email", "mirza.komakhidze@mail.ru");
		temp.put("mobilePhone", "555176793");
		jLog0.put("UpdateClientMainDataCommand", temp);

		temp = new JSONObject();
		jLog1.put("VoidResponse", temp);

		temp = new JSONObject();
		temp.put("id", "1209588");
		temp.put("clientId", "435538");
		temp.put("clientFullName", "მარიამ მამადაშვილი");
		temp.put("clientMobilePhone", "577320478");
		temp.put("term", "30 DAYS");
		temp.put("amount", 1000);
		temp.put("applicationType", "WEB");
		temp.put("status", "OPEN");
		temp.put("confirmed", false);
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
		temp.put("loansCount", 2);
		temp.put("creditScore", null);
		temp.put("testScorecardCreditScore", null);
		temp.put("askedAmount", 1000);
		temp.put("askedTerm", "30 DAYS");
		temp.put("calculatedCreditLimit", null);
		temp.put("additionalAmountApplication", false);
		temp.put("flowState", "NEW");
		temp.put("flowStateDetails", null);
		temp.put("flowStateStartDateTime", "2016-03-24T15:26:18.618");
		temp.put("brokerPartnerName", null);
		temp.put("iovationBlackbox", null);
		
		jLog3.put("LoanApplicationBean", temp);

		temp = new JSONObject();
		temp.put("clientId", "435538");
		temp.put("term", "30 DAYS");
		temp.put("applicationType", "WEB");
		jLog4.put("ApplyForLoanCommand", temp);

		logger.info(log0);
		logger.info(jLog0.toJSONString());
		logger.info(log1);
		logger.info(jLog1.toJSONString());
		logger.info(log3);
		logger.info(jLog3.toJSONString());
		logger.info(log4);
		logger.info(jLog4.toJSONString());

		try {
			//noinspection ResultOfMethodCallIgnored
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
