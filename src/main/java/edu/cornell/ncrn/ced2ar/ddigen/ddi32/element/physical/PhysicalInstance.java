package edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.physical;

import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.ElementWithUrn;
import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.record.RecordLayoutReference;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PhysicalInstance extends ElementWithUrn {

	public static final String NODE_NAME_PHYSICAL_INSTANCE = "pi:PhysicalInstance";
	public static final String NODE_NAME_DATA_FILE_IDENTIFICATION = "pi:DataFileIdentification";
	public static final String NODE_NAME_DATA_FILE_URI = "pi:DataFileURI";

	private RecordLayoutReference recordLayoutReference;
	private GrossFileStructure grossRecordStructure;
	private StatisticalSummary statisticalSummary;
	private String dataFileUri;

	public PhysicalInstance(String agency) {
		super(agency);
	}

	@Override
	public void appendToElement(Element element, Document doc) {
		Element physicalStructure = doc.createElement(NODE_NAME_PHYSICAL_INSTANCE);

		super.appendToElement(physicalStructure, doc);

		// Record Layout Reference
		getRecordLayoutReference().appendToElement(physicalStructure, doc);

		// Data File Identification
		Element dataFileIdentification = doc.createElement(NODE_NAME_DATA_FILE_IDENTIFICATION);
		Element dataFileUri = doc.createElement(NODE_NAME_DATA_FILE_URI);
		dataFileUri.setTextContent(getDataFileUri());
		dataFileIdentification.appendChild(dataFileUri);
		physicalStructure.appendChild(dataFileIdentification);

		// Gross File Structure
		getGrossRecordStructure().appendToElement(physicalStructure, doc);

		// Statistical Summary
		getStatisticalSummary().appendToElement(physicalStructure ,doc);

		element.appendChild(physicalStructure);
	}

	public GrossFileStructure getGrossRecordStructure() {
		return grossRecordStructure;
	}

	public RecordLayoutReference getRecordLayoutReference() {
		return recordLayoutReference;
	}

	public StatisticalSummary getStatisticalSummary() {
		return statisticalSummary;
	}

	public String getDataFileUri() {
		return dataFileUri;
	}

	public void setRecordLayoutReference(RecordLayoutReference recordLayoutReference) {
		this.recordLayoutReference = recordLayoutReference;
	}

	public void setGrossRecordStructure(GrossFileStructure grossRecordStructure) {
		this.grossRecordStructure = grossRecordStructure;
	}

	public void setStatisticalSummary(StatisticalSummary statisticalSummary) {
		this.statisticalSummary = statisticalSummary;
	}

	public void setDataFileUri(String dataFileUri) {
		this.dataFileUri = dataFileUri;
	}
}
