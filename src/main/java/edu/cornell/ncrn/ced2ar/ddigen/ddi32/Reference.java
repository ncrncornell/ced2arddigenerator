package edu.cornell.ncrn.ced2ar.ddigen.ddi32;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class Reference extends ElementWithUrn {

	public static final String NODE_NAME_TYPE_OF_OBJECT = "r:TypeOfObject";

	private String name;
	private ReferenceObjectType objectType;

	public Reference(String id, String agency, int version, String name, ReferenceObjectType objectType) {
		super(id, agency, version);
		setName(name);
		setObjectType(objectType);
	}

	@Override
	public void appendToElement(Element element, Document doc) {
		Element variableUsedReference = doc.createElement(getName());

		super.appendToElement(variableUsedReference, doc);

		Element objectType = doc.createElement(NODE_NAME_TYPE_OF_OBJECT);
		objectType.setTextContent(getObjectType().toString());
		variableUsedReference.appendChild(objectType);

		element.appendChild(variableUsedReference);
	}

	public String getName() {
		return name;
	}

	public ReferenceObjectType getObjectType() {
		return objectType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setObjectType(ReferenceObjectType objectType) {
		this.objectType = objectType;
	}
}