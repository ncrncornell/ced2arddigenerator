package edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.physical;

import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.ElementWithUrn;
import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.variable.VariableReference;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class VariableStatistics extends ElementWithUrn {

	public static final String NODE_NAME_VARIABLE_STATISTICS = "pi:VariableStatistics";

	private VariableReference variableReference;
	private List<SummaryStatistic> summaryStatisticList = new ArrayList<>();

	public VariableStatistics(String agency) {
		super(agency);
	}

	public void addSummaryStatistic(SummaryStatisticType type, String statistic) {
		synchronized (this.summaryStatisticList) {
			this.summaryStatisticList.add(new SummaryStatistic(type, statistic, getAgency()));
		}
	}

	@Override
	public void appendToElement(Element element, Document doc) {
		Element variableStatistics = doc.createElement(NODE_NAME_VARIABLE_STATISTICS);

		getVariableReference().appendToElement(variableStatistics, doc);

		for (SummaryStatistic summaryStatistic : getSummaryStatisticList()) {
			summaryStatistic.appendToElement(variableStatistics, doc);
		}

		element.appendChild(variableStatistics);
	}

	public List<SummaryStatistic> getSummaryStatisticList() {
		return summaryStatisticList;
	}

	public VariableReference getVariableReference() {
		return variableReference;
	}

	public void setVariableReference(VariableReference variableReference) {
		this.variableReference = variableReference;
	}
}
