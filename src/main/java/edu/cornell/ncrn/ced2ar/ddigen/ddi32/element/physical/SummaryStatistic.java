package edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.physical;

import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.ElementWithUrn;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SummaryStatistic extends ElementWithUrn {

	public static final String NODE_NAME_SUMMARY_STATISTIC = "pi:SummaryStatistic";
	public static final String NODE_NAME_TYPE_OF_SUMMARY_STATISTIC = "pi:TypeOfSummaryStatistic";
	public static final String NODE_NAME_STATISTIC = "pi:Statistic";

	private SummaryStatisticType type;
	private String statistic;

	public SummaryStatistic(SummaryStatisticType type, String statistic, String agency) {
		super(agency);

		setStatistic(statistic);
		setType(type);
	}

	@Override
	public void appendToElement(Element element, Document doc) {
		Element summaryStatistic = doc.createElement(NODE_NAME_SUMMARY_STATISTIC);

		// Type Of Summary Statistic
		Element type = doc.createElement(NODE_NAME_TYPE_OF_SUMMARY_STATISTIC);
		type.setTextContent(getType().toString());
		summaryStatistic.appendChild(type);

		// Statistic
		Element statistic = doc.createElement(NODE_NAME_STATISTIC);
		statistic.setTextContent(getStatistic());
		summaryStatistic.appendChild(statistic);

		element.appendChild(summaryStatistic);
	}

	public String getStatistic() {
		return statistic;
	}

	public SummaryStatisticType getType() {
		return type;
	}

	public void setStatistic(String statistic) {
		this.statistic = statistic;
	}

	public void setType(SummaryStatisticType type) {
		this.type = type;
	}
}
