package edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.record;

import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.Reference;
import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.ReferenceObjectType;

public class RecordLayoutReference extends Reference {

	public static final String NODE_NAME_RECORD_LAYOUT_REFERENCE = "r:RecordLayoutReference";

	public RecordLayoutReference(String id, String agency) {
		super(id, agency, NODE_NAME_RECORD_LAYOUT_REFERENCE, ReferenceObjectType.RecordLayout);
	}
}
