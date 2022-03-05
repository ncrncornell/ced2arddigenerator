package edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.physical;

import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.ElementWithUrn;
import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.Label;
import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.Name;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GrossFileStructure extends ElementWithUrn {

	public static final String NODE_NAME_GROSS_FILE_STRUCTURE = "pi:GrossFileStructure";
	public static final String NODE_NAME_CREATION_SOFTWARE = "pi:CreationSoftware";
	public static final String NODE_NAME_SOFTWARE_NAME = "r:SoftwareName";
	public static final String NODE_NAME_DESCRIPTION = "r:Description";
	public static final String NODE_NAME_CASE_QUANTITY = "pi:CaseQuantity";

	private Name softwareName;
	private Label description;
	private int caseCount;

	public GrossFileStructure(String agency) {
		super(agency);
	}

	@Override
	public void appendToElement(Element element, Document doc) {
		Element grossFileStructure = doc.createElement(NODE_NAME_GROSS_FILE_STRUCTURE);

		// Creation Software
		Element creationSoftware = doc.createElement(NODE_NAME_CREATION_SOFTWARE);
		getSoftwareName().appendToElement(creationSoftware, doc);
		getDescription().appendToElement(creationSoftware, doc);
		grossFileStructure.appendChild(creationSoftware);

		// Case Quantity
		Element caseQuantity = doc.createElement(NODE_NAME_CASE_QUANTITY);
		caseQuantity.setTextContent(Integer.toString(getCaseCount()));
		grossFileStructure.appendChild(caseQuantity);

		element.appendChild(grossFileStructure);
	}

	public int getCaseCount() {
		return caseCount;
	}

	public Label getDescription() {
		return description;
	}

	public Name getSoftwareName() {
		return softwareName;
	}

	public void setCaseCount(int caseCount) {
		this.caseCount = caseCount;
	}

	public void setDescription(Label description) {
		this.description = description;
	}

	public void setSoftwareName(String content) {
		this.softwareName = new Name(NODE_NAME_SOFTWARE_NAME, content);
	}
}
