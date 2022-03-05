package edu.cornell.ncrn.ced2ar.ddigen.ddi32.element;

import edu.cornell.ncrn.ced2ar.ddigen.Appendable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Label implements Appendable {

	public static final String NODE_NAME_LABEL = "r:Label";
	public static final String NODE_NAME_CONTENT = "r:Content";

	private String content;
	private String ddiLanguage;
	private String label;

	public Label(String content, String ddiLanguage) {
		setContent(content);
		setDdiLanguage(ddiLanguage);
		setLabel(NODE_NAME_LABEL);
	}

	public Label(String label ,String content, String ddiLanguage) {
		setLabel(label);
		setContent(content);
		setDdiLanguage(ddiLanguage);
	}

	@Override
	public void appendToElement(Element element, Document doc) {
		Element label = doc.createElement(getLabel());

		Element content = doc.createElement(NODE_NAME_CONTENT);
		content.setTextContent(getContent());

		label.appendChild(content);

		element.appendChild(label);
	}

	public String getContent() {
		return content;
	}

	public String getDdiLanguage() {
		return ddiLanguage;
	}

	public String getLabel() {
		return label;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDdiLanguage(String ddiLanguage) {
		this.ddiLanguage = ddiLanguage;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
