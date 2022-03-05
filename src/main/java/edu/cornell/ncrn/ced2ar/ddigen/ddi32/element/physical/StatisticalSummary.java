package edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.physical;

import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.ElementWithUrn;
import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.Name;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class StatisticalSummary extends ElementWithUrn {

	public static final String NODE_NAME_STATISTICAL_SUMMARY = "pi:StatisticalSummary";

	private final List<VariableStatistics> variableStatisticsList = new ArrayList<>();

	public StatisticalSummary(String agency) {
		super(agency);
	}

	public void addVariableStatistics(VariableStatistics variableStatistics) {
		synchronized (variableStatisticsList) {
			this.variableStatisticsList.add(variableStatistics);
		}
	}

	@Override
	public void appendToElement(Element element, Document doc) {
		Element statisticalSummary = doc.createElement(NODE_NAME_STATISTICAL_SUMMARY);

		for (VariableStatistics variableStatistics : getVariableStatisticsList()) {
			variableStatistics.appendToElement(statisticalSummary, doc);
		}

		element.appendChild(statisticalSummary);
	}

	public List<VariableStatistics> getVariableStatisticsList() {
		return variableStatisticsList;
	}
}
